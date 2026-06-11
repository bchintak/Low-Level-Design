package com.library.service;

import com.library.enums.BookStatus;
import com.library.model.*;

public class LendingService {

    public BookLending checkout(
            Member member,
            BookItem bookItem) {

        if(bookItem.getStatus()
                != BookStatus.AVAILABLE) {

            throw new RuntimeException(
                    "Book not available");
        }

        bookItem.setStatus(BookStatus.LOANED);

        BookLending lending =
                new BookLending(bookItem, member);

        member.getBorrowedBooks()
                .add(lending);

        return lending;
    }

    public void returnBook(BookItem item) {

        item.setStatus(BookStatus.AVAILABLE);
    }
}