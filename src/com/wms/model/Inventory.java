package com.wms.model;

public class Inventory {

    private Product product;
    private int quantity;

    public Inventory(Product product,
                     int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void addStock(int qty) {
        quantity += qty;
    }

    public void removeStock(int qty) {
        quantity -= qty;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}