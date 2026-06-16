package com.design_patterns.structural.decorator;

public class SugarDecorator
        extends CoffeeDecorator {

    public SugarDecorator(
            Coffee coffee) {

        super(coffee);
    }

    @Override
    public double cost() {

        return coffee.cost() + 10;
    }
}
