package com.design_patterns.creational.builder;

public class Main {

    public static void main(String[] args) {

        Employee employee = new EmployeeBuilder()
                .id("101")
                .name("Bhanu")
                .age(28)
                .department("Engineering")
                .build();

        System.out.println(employee);
    }
}
