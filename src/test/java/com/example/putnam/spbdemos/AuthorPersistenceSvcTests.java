package com.example.putnam.spbdemos;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.Optional;

import com.example.putnam.spbdemos.dao.AuthorRepository;
import com.example.putnam.spbdemos.domain.Author;
import com.example.putnam.spbdemos.svcs.AuthorPersistenceServiceImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorPersistenceSvcTests {
    
    @Autowired
    AuthorRepository daoRef;

    @Autowired
    AuthorPersistenceServiceImpl svcRef;

    @BeforeEach
    public void init() {
        // initialize with standard data set
    }

    @AfterEach
    public void destroy() {
        this.daoRef.deleteAll();
    }

    @Test
    public void registerNewAuthor() {
        String fn = "Janet"; String ln = "Java";
        Author a = new Author(fn,ln);
        Optional<Author> rtn = this.svcRef.registerNewAuthor(a);
        assumingThat(rtn.isPresent(), () -> {
            Author authRef = rtn.get();
            assertAll(
                () -> assertEquals(fn,authRef.getFirstName()),
                () -> assertEquals(ln,authRef.getLastName())
            );
        });
    }

    @Test
    public void updateCurrentPersistedAuthor() {
            //TODO
    }

}
