package com.project.Exchange.Controllers;

import com.project.Exchange.Models.Balance;
import com.project.Exchange.Models.Order;
import com.project.Exchange.Models.User;
import com.project.Exchange.Services.OrderService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    List<Order> bids;
    List<Order> asks;
    @PostConstruct
    void init(){
        bids = new ArrayList<>();
        asks = new ArrayList<>();
    }

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
