package com.example.putnam.spbdemos.endpoints;

import com.example.putnam.spbdemos.domain.Vendor;
import com.example.putnam.spbdemos.svcs.VendorPersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/vendor",
produces = MediaType.APPLICATION_JSON_VALUE)
public class VendorController {
    Logger log = LoggerFactory.getLogger(VendorController.class);
    private final VendorPersistenceService vendSvc;

    public VendorController(VendorPersistenceService vendSvc) {
        this.vendSvc = vendSvc;
    }

    @GetMapping(path = "current")
    public List<Vendor> getCurrentVendorList(){
        return this.vendSvc.getCurrentVendors();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerNewVendor(@RequestBody Vendor nueVendor){
        //TODO logic for vendor acceptance
        if (nueVendor != null){
            return ResponseEntity.accepted().body(this.vendSvc.addNueVendor(nueVendor));
        }
        return ResponseEntity.badRequest().body("Failed to provide new vendor!");
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateExistingVendor(@RequestBody Vendor vendor){
        //TODO logic for vendor acceptance
        Optional<Vendor> rtnVendor = this.vendSvc.updateCurrentVendor(vendor);
        if (rtnVendor.isPresent()){
            return ResponseEntity.accepted().body(rtnVendor);
        }
        return ResponseEntity.notFound().build();
    }

}
