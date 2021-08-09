package com.example.putnam.spbdemos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import com.example.putnam.spbdemos.domain.Author;
import com.example.putnam.spbdemos.domain.Book;
import com.example.putnam.spbdemos.svcs.MockBookFinderImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
@SpringBootTest
public class MockBookDataImplTests {
    
    @Resource
    ApplicationContext ctx;
    MockBookFinderImpl bean;

    @BeforeEach
    public void initTestData() {
        this.bean = (MockBookFinderImpl)ctx.getBean(MockBookFinderImpl.class);
    }

    @AfterEach
    public void cleanUpTestData() {
        this.bean.getCurrentBooks().clear();
    }

    @Test
    public void verifyManagedMockBookImplPresent() {
        assertNotNull(
            ctx.getBean(MockBookFinderImpl.class),
            "mock book finder failed configuration instantiation");
    }

    @Test
    public void verifyMockBookImpleAcceptsBulkUpdate() {
        this.bean.addBooks(DataGenerator.getSampleBooks());
        assertEquals(
            DataGenerator.getSampleBooks().size(),
            this.bean.getCurrentBooks().size(),
            "failed to add bulk updates of equal size");
    }

    @Test
    public void verifySearchByTitleReturnsCorrectBook() {
        List<Book> bookCache = DataGenerator.getSampleBooks();
        String searchTitle = "Jupiter testing rocks convenience";
        bookCache.add(new Book(searchTitle,new Author("bobo","Da Clown"),21));
        this.bean.addBooks(bookCache);
        Optional<Book> foundBook = this.bean.findByTitle(searchTitle);
        assertTrue(foundBook.isPresent(),"book added not found upon search");
        assertEquals(searchTitle, foundBook.get().getTitle(),"title didn't match inserted object");
    }

    @Test
    public void findAllBooksByAuthorLastName() {
        
    }
}
