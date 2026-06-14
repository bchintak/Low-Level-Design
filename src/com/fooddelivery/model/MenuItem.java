package com.fooddelivery.model;

public class MenuItem {

    private String id;
    private String name;
    private double price;

    public MenuItem(String id,
                    String name,
                    double price) {

        this.id=id;
        this.name=name;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}