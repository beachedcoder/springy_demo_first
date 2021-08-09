package com.example.putnam.spbdemos.svcs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.putnam.spbdemos.domain.Book;

public class MockBookFinderImpl implements BookFinderService {

    private List<Book> books;

    public MockBookFinderImpl() {
        super();
        this.books = new ArrayList<>();
    }

    public MockBookFinderImpl(List<Book> cache) {
        this();
        this.books.addAll(cache);
    }

    public void addBooks(List<Book> donations) {
        this.books.addAll(donations);
    }

    @Override
    public Optional<Book> findByTitle(String searchTitle) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> getCurrentBooks() {
        return this.books;
    }
    
}
