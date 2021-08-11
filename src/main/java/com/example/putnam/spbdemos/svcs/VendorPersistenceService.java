package com.example.putnam.spbdemos.svcs;

import com.example.putnam.spbdemos.dao.VendorRepository;
import com.example.putnam.spbdemos.domain.Vendor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class VendorPersistenceService {
    //TODO wrap JPA functionality
    // place business logic (validation, etc...)
    // 
    private final VendorRepository dao;

    public VendorPersistenceService(VendorRepository svcRef) {
        this.dao = svcRef;
    }

    public List<Vendor> getCurrentVendors() {
        return StreamSupport.stream(this.dao.findAll().spliterator(),false).collect(Collectors.toList());
    }

    public Vendor addNueVendor(Vendor nueVendor) {
       return this.dao.save(nueVendor);
    }

    public Optional<Vendor> updateCurrentVendor(Vendor v) {
        Optional<Vendor> existingVendor = this.dao.findById(v.getId());
        if(existingVendor.isPresent()){
            return Optional.of(this.dao.save(v));
        }
        return Optional.empty();
    }
}
