package com.rideshare.model;

public abstract class User {

    protected String id;
    protected String name;
    protected String phone;

    public User(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}