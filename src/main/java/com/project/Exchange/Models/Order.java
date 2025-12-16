package com.project.Exchange.Models;

public class Order {



    public Order(int userID, int price, int quantity, String type) {
        this.userID = userID;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public void setUser(int userID) {
        this.userID = userID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserID() {
        return userID;
    }

    private int userID;

    private int price;

    private int quantity;

    private String type;

}
