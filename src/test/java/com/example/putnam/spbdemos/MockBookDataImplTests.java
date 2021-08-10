package com.example.putnam.spbdemos;

import com.example.putnam.spbdemos.domain.Author;
import com.example.putnam.spbdemos.domain.Book;
import com.example.putnam.spbdemos.svcs.MockBookFinderImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class MockBookDataImplTests {
    
    @Resource
    ApplicationContext ctx;
    MockBookFinderImpl bean;

    @BeforeEach
    public void initTestData() {
        this.bean = (MockBookFinderImpl)ctx.getBean(MockBookFinderImpl.class);
        this.bean.addBooks(DataGenerator.getSampleBooks());
    }

    @AfterEach
    public void cleanUpTestData() {
        this.bean.getCurrentBooks().clear();
    }

    @Test
    public void verifyManagedMockBookImplPresent() {
        // acceptable demo test but useless in practice
        assertNotNull(
            ctx.getBean(MockBookFinderImpl.class),
            "mock book finder failed configuration instantiation");
    }

    @Test
    public void verifyMockBookImpleAcceptsBulkUpdate() {
        assertEquals(
            DataGenerator.getSampleBooks().size(),
            this.bean.getCurrentBooks().size(),
            "failed to add bulk updates of equal size");
    }

    @Test
    public void verifySearchByTitleReturnsCorrectBook() {
        String searchTitle = "Jupiter testing rocks convenience";
        this.bean.addBook(new Book(searchTitle,new Author("bobo","Da Clown"),21));
        Optional<Book> foundBook = this.bean.findByTitle(searchTitle);
        assertTrue(foundBook.isPresent(),"book added not found upon search");
        assertEquals(searchTitle, foundBook.get().getTitle(),"title didn't match inserted object");
    }

    @Test
    public void findAllBooksByAuthorLastName() {
        String lName = "Java"; // based on DataGenerator class

    }
}
