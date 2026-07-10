package com.design_patterns.creational.prototype;

public class Employee implements Prototype {

    private String id;
    private String name;
    private String department;

    public Employee(String id,
                    String name,
                    String department) {

        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public Prototype clone() {
        return new Employee(id, name, department);
    }

    @Override
    public String toString() {

        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
