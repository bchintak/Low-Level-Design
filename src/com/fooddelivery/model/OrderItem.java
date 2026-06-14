package com.fooddelivery.model;

public class OrderItem {

    private MenuItem menuItem;

    private int quantity;

    private double itemPrice;

    public OrderItem(MenuItem menuItem,
                     int quantity) {

        this.menuItem = menuItem;
        this.quantity = quantity;
        this.itemPrice = menuItem.getPrice();
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getTotalPrice() {
        return itemPrice * quantity;
    }
}