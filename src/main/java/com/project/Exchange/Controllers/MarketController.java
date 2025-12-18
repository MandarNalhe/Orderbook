package com.project.Exchange.Controllers;

import com.project.Exchange.Services.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/market")
public class MarketController {

    @Autowired
    MarketService marketService;
    @GetMapping("/price")
    ResponseEntity<Integer> getMarketPrice(){
        int price = marketService.handlePrice();
        return ResponseEntity.status(HttpStatus.OK).body(price);
    }
}
