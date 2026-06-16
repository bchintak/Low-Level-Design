package com.design_patterns.structural.decorator;

public class Main {

    public static void main(String[] args) {

        Coffee coffee =
                new SimpleCoffee();

        System.out.println(
                coffee.cost());

        coffee =
                new MilkDecorator(
                        coffee);
        System.out.println(
                coffee.cost());

        coffee =
                new SugarDecorator(
                        coffee);

        System.out.println(
                coffee.cost());
    }
}
