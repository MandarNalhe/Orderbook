package com.project.Exchange.Services;

import com.project.Exchange.DAO.Users;
import com.project.Exchange.Models.Order;
import com.project.Exchange.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    Users users;

    @Autowired
    DepthService depthService;
    public int handle(Order order, List<Order> bids, List<Order> asks){

        int remaining = fillupOrder(order,bids,asks);
        if(remaining != 0){
            bids.add(new Order(order.getUserID(), order.getPrice(), remaining, order.getType()));
            bids.sort((a,b)-> Integer.compare(b.getPrice(),a.getPrice()));
            depthService.handleDepth().add( new Order(order.getUserID(), order.getPrice(), remaining, order.getType()));
            depthService.handleDepth().sort((a,b) -> Integer.compare(b.getPrice(),a.getPrice()));
        }
        else{
            asks.add(new Order(order.getUserID(), order.getPrice(), remaining, order.getType()));
            asks.sort(Comparator.comparingInt(Order::getPrice));
            depthService.handleDepth().add(new Order(order.getUserID(), order.getPrice(),remaining, order.getType()));
            depthService.handleDepth().sort((a,b)->Integer.compare(b.getPrice(),a.getPrice()));
        }
        return remaining;
    }

    public int fillupOrder(Order order, List<Order> bids, List<Order> asks){
        int remain = order.getQuantity();
        if(order.getType().equals("bid")) {
            for (Order order1 : asks) {
                if (order.getPrice() < order1.getPrice()) {
                    break;
                }
                if (remain <= order1.getQuantity()) {
                    order1.setQuantity(order1.getQuantity() - remain);
                    flipOrder(order1.getUserID(), order.getUserID(), remain,order1.getPrice());
                    return 0;
                } else {
                    remain -= order1.getQuantity();
                    flipOrder(order1.getUserID(), order.getUserID(), remain, order1.getPrice());
                }
            }
        }
        for(Order order1 : bids){
            if(order.getPrice() > order1.getPrice()){
                break;
            }
            if(remain <= order1.getQuantity()){
                order1.setQuantity(order1.getQuantity()-remain);
                flipOrder(order.getUserID(),order1.getUserID(),remain, order1.getPrice());
                return 0;
            }
            else{
                remain -= order1.getQuantity();
                flipOrder(order.getUserID(),order1.getUserID(),remain, order1.getPrice());
            }
        }
        return remain;
    }

    private void flipOrder(int userID, int userID2, int remain, int price) {
        User user = new User(), user1 = new User();
        for(User u : users.getUsers()){
            if(u.getUserID() == userID){
                user = u;
            }
            if(u.getUserID() == userID2){
                user1 = u;
            }
        }
        user.getBalance().setAmount(user.getBalance().getAmount() + (remain*price));
        user.getBalance().setTicker(user.getBalance().getTicker()-remain);
        user1.getBalance().setAmount(user1.getBalance().getAmount() - (remain*price));
        user1.getBalance().setTicker(user1.getBalance().getTicker()+remain);
    }

}
