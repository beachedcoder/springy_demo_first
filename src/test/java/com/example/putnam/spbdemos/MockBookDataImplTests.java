package com.example.putnam.spbdemos;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.annotation.Resource;

import com.example.putnam.spbdemos.svcs.MockBookFinderImpl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class MockBookDataImplTests {
    
    @Resource
    ApplicationContext ctx;

    @Test
    public void verifyManagedMockBookImplPresent() {
        assertNotNull(ctx.getBean(MockBookFinderImpl.class));
    }

    
}
