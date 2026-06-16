package com.design_patterns.behavioural.iterator;

public class BookCollection
        implements Collection<String> {

    private String[] books;

    public BookCollection(
            String[] books) {

        this.books = books;
    }

    @Override
    public Iterator<String> iterator() {

        return new BookIterator(books);
    }
}
