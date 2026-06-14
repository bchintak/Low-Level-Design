package com.fooddelivery.service;

import com.fooddelivery.model.Cart;
import com.fooddelivery.model.MenuItem;

public class CartService {

    public void addItem(
            Cart cart,
            MenuItem item,
            int quantity) {

        cart.addItem(
                item,
                quantity
        );
    }

    public double getCartAmount(
            Cart cart) {

        return cart.getTotalAmount();
    }

    public void clearCart(
            Cart cart) {

        cart.clear();
    }
}