package com.project.Exchange.Models;

public class Order {

    public User getUser() {
        return user;
    }

    public Order(User user, int price, int quantity, String type) {
        this.user = user;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public void setUser(User user) {
        this.user = user;
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

    private User user;

    private int price;

    private int quantity;

    private String type;

}
