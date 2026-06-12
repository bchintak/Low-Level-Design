package com.bookmyshow.strategy;

import com.bookmyshow.model.ShowSeat;

public class NormalPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(ShowSeat showSeat) {
        return showSeat.getPrice();
    }
}
