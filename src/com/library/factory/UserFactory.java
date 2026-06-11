package com.library.factory;

import com.library.model.*;

public class UserFactory {

    public static User createUser(
            String type,
            String id,
            String name,
            String email) {

        if(type.equalsIgnoreCase("MEMBER"))
            return new Member(id,name,email);

        if(type.equalsIgnoreCase("LIBRARIAN"))
            return new Librarian(id,name,email);

        throw new IllegalArgumentException();
    }
}