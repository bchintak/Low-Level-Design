package com.design_patterns.creational.builder;

public class EmployeeBuilder {

    private String id;
    private String name;
    private int age;
    private String department;

    public EmployeeBuilder id(String id) {
        this.id = id;
        return this;
    }

    public EmployeeBuilder name(String name) {
        this.name = name;
        return this;
    }

    public EmployeeBuilder age(int age) {
        this.age = age;
        return this;
    }

    public EmployeeBuilder department(String department) {
        this.department = department;
        return this;
    }

    public Employee build() {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id is mandatory");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is mandatory");
        }

        return new Employee(id, name, age, department);
    }
}
