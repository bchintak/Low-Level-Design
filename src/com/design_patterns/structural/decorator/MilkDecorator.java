package com.design_patterns.structural.decorator;

public class MilkDecorator
        extends CoffeeDecorator {

    public MilkDecorator(
            Coffee coffee) {

        super(coffee);
    }

    @Override
    public double cost() {

        return coffee.cost() + 20;
    }
}
