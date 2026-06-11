package com.library.model;

import java.time.LocalDate;

public class BookLending {

    private BookItem bookItem;

    private Member member;

    private LocalDate issueDate;

    private LocalDate dueDate;

    public BookLending(BookItem bookItem,
                       Member member) {

        this.bookItem = bookItem;
        this.member = member;

        issueDate = LocalDate.now();

        dueDate = issueDate.plusDays(14);
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}