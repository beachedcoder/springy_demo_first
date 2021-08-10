package com.example.putnam.spbdemos.dao;

import com.example.putnam.spbdemos.domain.Author;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
    
}
