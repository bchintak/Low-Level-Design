package com.library.model;

import com.library.enums.BookStatus;

public class BookItem {

    private String barcode;

    private Book book;

    private BookStatus status;

    public BookItem(String barcode,
                    Book book) {

        this.barcode = barcode;
        this.book = book;
        this.status = BookStatus.AVAILABLE;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public String getBarcode() {
        return barcode;
    }
}