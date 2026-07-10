package com.design_patterns.creational.builder;

public class Employee {

    private final String id;
    private final String name;
    private final int age;
    private final String department;

    public Employee(String id,
                    String name,
                    int age,
                    String department) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}
