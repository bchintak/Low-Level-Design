package com.splitwise.model;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String id;
    private String name;

    private List<User> members = new ArrayList<>();

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addMember(User user) {
        members.add(user);
    }

    public List<User> getMembers() {
        return members;
    }
}