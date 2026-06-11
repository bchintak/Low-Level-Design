package com.library.catalog;

import com.library.model.Book;

import java.util.*;

public class Catalog {

    private Map<String, Book> books =
            new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book searchByISBN(String isbn) {
        return books.get(isbn);
    }

    public List<Book> searchByTitle(String title) {

        List<Book> result = new ArrayList<>();

        for(Book book : books.values()) {

            if(book.getTitle()
                    .toLowerCase()
                    .contains(title.toLowerCase())) {

                result.add(book);
            }
        }

        return result;
    }
}