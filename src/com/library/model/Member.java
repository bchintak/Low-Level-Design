package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {

    private List<BookLending> borrowedBooks =
            new ArrayList<>();

    public Member(String id,
                  String name,
                  String email) {
        super(id, name, email);
    }

    public List<BookLending> getBorrowedBooks() {
        return borrowedBooks;
    }
}