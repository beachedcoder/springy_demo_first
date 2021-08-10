package com.example.putnam.spbdemos.domain;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private UUID accountCode;
    
    public Vendor() {
        super();
        this.accountCode = UUID.randomUUID();
    }

    public Vendor(String vName, UUID acctCode) {
        this();
        this.name = vName; this.accountCode = acctCode;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public UUID getAccountCode() {
        return accountCode;
    }
    public void setAccountCode(UUID accountCode) {
        this.accountCode = accountCode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(!(obj instanceof Vendor)) return false;
        Vendor v = (Vendor) obj;
        return getId()==v.getId() &&
        getAccountCode().equals(v.getAccountCode()) &&
        getName().equalsIgnoreCase(v.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getAccountCode(),getName());
    }
}
