package com.example.putnam.spbdemos.svcs;

import com.example.putnam.spbdemos.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public void addBooks(List<Book> donations) {
        this.books.addAll(donations);
    }

    @Override
    public void addBook(Book donation) {
        this.books.add(donation);
    }

    @Override
    public Optional<Book> removeBookByTitle(String title) {
        Optional<Book> rtnValue = this.books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst();
        if (rtnValue.isPresent()){
            this.books.remove(rtnValue.get());
            return rtnValue;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> findByTitle(String searchTitle) {
        return this.books.stream().filter(t -> t.getTitle().contains(searchTitle)).findFirst();
    }

    @Override
    public List<Book> getCurrentBooks() {
        return this.books;
    }

    @Override
    public List<Book> findByAuthorLastName(String lastName) {
        return this.books.stream().filter(a -> a.getAuthor().getLastName().equalsIgnoreCase(lastName)).collect(Collectors.toList());
    }
    
}
