package com.example.putnam.spbdemos.dao;

import com.example.putnam.spbdemos.domain.Vendor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends CrudRepository<Vendor,Long> {
    
}
