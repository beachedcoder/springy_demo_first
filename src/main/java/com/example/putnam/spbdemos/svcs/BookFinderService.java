package com.example.putnam.spbdemos.svcs;

import java.util.List;
import java.util.Optional;

import com.example.putnam.spbdemos.domain.Book;

public interface BookFinderService {
    Optional<Book> findByTitle(String searchTitle);
    List<Book> getCurrentBooks();
}
