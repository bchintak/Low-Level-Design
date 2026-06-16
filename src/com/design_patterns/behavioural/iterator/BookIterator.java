package com.design_patterns.behavioural.iterator;

public class BookIterator
        implements Iterator<String> {

    private String[] books;

    private int index = 0;

    public BookIterator(
            String[] books) {

        this.books = books;
    }

    @Override
    public boolean hasNext() {

        return index < books.length;
    }

    @Override
    public String next() {

        return books[index++];
    }
}
