package com.design_patterns.creational.prototype;

public class Main {

    public static void main(String[] args) {

        Employee employee1 =
                new Employee("101",
                        "Bhanu",
                        "Engineering");

        Employee employee2 =
                (Employee) employee1.clone();

        System.out.println(employee1);

        System.out.println(employee2);
    }
}
