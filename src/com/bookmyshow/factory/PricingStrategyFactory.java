package com.bookmyshow.factory;

import com.bookmyshow.strategy.NormalPricingStrategy;
import com.bookmyshow.strategy.PricingStrategy;
import com.bookmyshow.strategy.WeekendPricingStrategy;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class PricingStrategyFactory {

    public static PricingStrategy getStrategy(
            LocalDate date) {

        return switch (date.getDayOfWeek()) {
            case SATURDAY, SUNDAY -> new WeekendPricingStrategy();
            default -> new NormalPricingStrategy();
        };
    }
}
