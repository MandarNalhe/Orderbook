package com.project.Exchange.Controllers;

import com.project.Exchange.Models.Balance;
import com.project.Exchange.Models.Order;
import com.project.Exchange.Models.User;
import com.project.Exchange.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class OrderController {

    List<Order> bids = new ArrayList<>();
    List<Order> asks = new ArrayList<>();

    User user1 = new User(1,new Balance());
    User user2 = new User(2,new Balance());

    @Autowired
    OrderService orderService;
    @PostMapping("/order")
    public ResponseEntity<String> orderController(@RequestBody Order order ){
        try{
            int remaining = orderService.handle(order, bids, asks);
            if(remaining == 0){
                return ResponseEntity.status(HttpStatus.OK).body("Oder placed fully");
            }
            return ResponseEntity.status(HttpStatus.OK).body("order partially placed, remaining :"+ remaining);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Error");
        }
    }
}
