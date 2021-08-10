package com.example.putnam.spbdemos.svcs;

import java.util.Optional;

import com.example.putnam.spbdemos.domain.Author;

public interface AuthorManagerService {
    Optional<Author> registerNewAuthor(Author writer);
}
