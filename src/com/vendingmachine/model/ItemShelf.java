package com.vendingmachine.model;

public class ItemShelf {

    private final int shelfCode;

    private Product product;

    private int quantity;

    public ItemShelf(int shelfCode,
                     Product product,
                     int quantity) {

        this.shelfCode = shelfCode;
        this.product = product;
        this.quantity = quantity;
    }

    public int getShelfCode() {
        return shelfCode;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void reduceQuantity() {

        if(quantity > 0) {
            quantity--;
        }
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}