package com.example.putnam.spbdemos.domain;

import java.time.Instant;
import java.util.Objects;

public class Author {
    private long id;
    private String firstName;
    private String lastName;
    public Author() {
        super();
        this.id = Instant.now().getNano();
    }
    public Author(String fName, String lName) {
        this();
        this.firstName = fName; this.lastName = lName;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Author)) return false;
        Author a = (Author) obj;
        return getId()==a.getId() &&
        getFirstName().equalsIgnoreCase(a.getFirstName()) &&
        getLastName().equalsIgnoreCase(a.getLastName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName());
    }
}
