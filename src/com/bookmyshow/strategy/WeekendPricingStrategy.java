package com.bookmyshow.strategy;

import com.bookmyshow.model.ShowSeat;

public class WeekendPricingStrategy
        implements PricingStrategy {

    @Override
    public double calculatePrice(ShowSeat showSeat) {
        return showSeat.getPrice() * 1.3;
    }
}
