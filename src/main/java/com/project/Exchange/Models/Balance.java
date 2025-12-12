package com.project.Exchange.Models;

import org.springframework.stereotype.Component;

@Component
public class Balance {

    public int getTicker() {
        return ticker;
    }

    public int getAmount() {
        return amount;
    }

    private int ticker = 10;

    private int amount = 1000;

    public void setTicker(int ticker) {
        this.ticker = ticker;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
