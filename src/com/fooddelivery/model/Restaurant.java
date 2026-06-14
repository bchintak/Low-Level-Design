package com.fooddelivery.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Restaurant {

    private String id;
    private String name;

    private List<MenuItem> menu =
            new ArrayList<>();

    public Restaurant(String id,
                      String name) {

        this.id=id;
        this.name=name;
    }

    public void addMenuItem(MenuItem item){
        menu.add(item);
    }
}