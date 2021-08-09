package com.example.putnam.spbdemos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import javax.annotation.Resource;

import com.example.putnam.spbdemos.svcs.MockBookFinderImpl;

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


    @Test
    public void verifyManagedMockBookImplPresent() {
        assertNotNull(ctx.getBean(MockBookFinderImpl.class));
    }

    @Test
    public void verifyMockBookImpleAcceptsBulkUpdate() {
        this.bean.addBooks(DataGenerator.getSampleBooks());
        assertEquals(
            DataGenerator.getSampleBooks().size(),
            this.bean.getCurrentBooks().size());
    }


}
