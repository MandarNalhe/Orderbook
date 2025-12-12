package com.project.Exchange.Models;

import org.springframework.stereotype.Component;

@Component
public class User {
    private int userID;
    private Balance balance;

    public User(int userID, Balance balance) {
        this.userID = userID;
        this.balance = balance;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}
