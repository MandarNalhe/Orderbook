package com.project.Exchange.Services;

import org.springframework.stereotype.Service;

@Service
public class MarketService {
    int price;
    public int handlePrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }
}
