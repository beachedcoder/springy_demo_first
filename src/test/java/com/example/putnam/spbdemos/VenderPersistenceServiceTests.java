package com.example.putnam.spbdemos;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.example.putnam.spbdemos.dao.VendorRepository;
import com.example.putnam.spbdemos.domain.Vendor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VenderPersistenceServiceTests {
    
    @Autowired
    VendorRepository dao;

    @BeforeEach
    public void initDataStore() {
        this.dao.saveAll(getVendorsForTest());
    }

    @AfterEach
    public void clearDataStore() {
        this.dao.deleteAll();
    }

    @Test
    public void demonstrateBeforeAfterEffect() {
        for (Vendor v : this.dao.findAll()) {
            System.out.println(v.getName());
        }
    }

    



    static List<Vendor> getVendorsForTest(){
        return Arrays.asList(
            new Vendor("Janet Java", UUID.randomUUID()),
            new Vendor("Nancy D'Net", UUID.randomUUID()),
            new Vendor("Katie Kotlin", UUID.randomUUID())   
        );
    }
}
