package com.bookmyshow.strategy;

import com.bookmyshow.model.ShowSeat;

public interface PricingStrategy {

    double calculatePrice(ShowSeat showSeat);
}
