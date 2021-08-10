package com.example.putnam.spbdemos.svcs;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.putnam.spbdemos.dao.AuthorRepository;
import com.example.putnam.spbdemos.domain.Author;

import org.springframework.stereotype.Service;

@Service
public class AuthorPersistenceServiceImpl implements AuthorManagementService {

    private final AuthorRepository dao;

    public AuthorPersistenceServiceImpl(AuthorRepository svcRef) {
        this.dao=svcRef;
    }
    
    @Override
    public Optional<Author> registerNewAuthor(Author writer) {
        //TODO add logic to ensure unique reqistration of authors
        return Optional.of(this.dao.save(writer));
    }

    @Override
    public Optional<Author> updateCurrentAuthor(Author writer) {
        Optional<Author> foundAuthor = this.dao.findById(writer.getId());
        if (foundAuthor.isPresent()){
            return Optional.of(this.dao.save(writer));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Author> findAuthorByFirstAndLast(String fName, String lName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Author> getCurrentAuthorRoster() {
        return StreamSupport.stream(this.dao.findAll().spliterator(), false).collect(Collectors.toList());
    }
    
}
