package com.example.putnam.spbdemos.svcs;

import java.util.List;
import java.util.Optional;

import com.example.putnam.spbdemos.domain.Author;

public interface AuthorManagementService {
    Optional<Author> registerNewAuthor(Author writer);
    Optional<Author> updateCurrentAuthor(Author writer);
    Optional<Author> findAuthorByFirstAndLast(String fName, String lName);
    List<Author> getCurrentAuthorRoster();
}
