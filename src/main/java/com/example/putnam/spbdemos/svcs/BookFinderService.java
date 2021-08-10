package com.example.putnam.spbdemos.svcs;

import com.example.putnam.spbdemos.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookFinderService {
    Optional<Book> findByTitle(String searchTitle);
    List<Book> findByAuthorLastName(String lastName);
    List<Book> getCurrentBooks();
    void addBooks(List<Book> donations);
    void addBook(Book donation);
    Optional<Book> removeBookByTitle(String title);
}
