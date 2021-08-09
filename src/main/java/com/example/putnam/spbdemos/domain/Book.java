package com.example.putnam.spbdemos.domain;

import java.time.Instant;
import java.util.Objects;

public class Book {
    private long id;
    private String title;
    private Author author;
    private int category;


    public Book() {
        super();
        this.id = Instant.now().getNano();
    }
    public Book(String title, Author author, int category) {
        this();
        this.title = title;
        this.author = author;
        this.category = category;
    }
    public long getId() {
        return id;
    }
    public Author getAuthor() {
        return author;
    }
    public int getCategory() {
        return category;
    }
    public String getTitle() {
        return title;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public void setCategory(int category) {
        this.category = category;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
   public boolean equals(Object obj) {
       if(this==obj) return true;
       if(!(obj instanceof Book)) return false;
       Book b = (Book)obj;
       return getId()==b.getId() && getCategory()==b.getCategory() && getTitle().equalsIgnoreCase(b.getTitle());
   }

   @Override
   public int hashCode() {
       return Objects.hash(getId(), getTitle(), getCategory());
   }
}
