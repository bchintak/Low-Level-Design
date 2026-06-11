package com.library.model;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private String subject;

    public Book(String isbn,
                String title,
                String author,
                String subject) {

        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.subject = subject;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }
}