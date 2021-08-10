package com.example.putnam.spbdemos;

import com.example.putnam.spbdemos.domain.Author;
import com.example.putnam.spbdemos.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static List<Book> getSampleBooks() {
        
        ArrayList<Book> rtnList = new ArrayList<>();
        Author mark = new Author("Mark","Twain");
        Author janet = new Author("Jane","Java");
        Author jose = new Author("jose","Javier");

        rtnList.add(new Book("Welcome to the Jungle", mark, 42));
        rtnList.add(new Book("Total fly fishing guide", mark, 42));
        rtnList.add(new Book("History of fly fishing", mark, 42));
        rtnList.add(new Book("Orvise fly fishing guide", mark, 42));
        rtnList.add(new Book("Lords of fly fishing", mark, 42));
        rtnList.add(new Book("A river runs through it", mark, 42));

        rtnList.add(new Book("Spring Love You!", janet, 23));
        rtnList.add(new Book("Dynamic Configuration rocks", mark, 23));

        rtnList.add(new Book("Desing Patterns in Java",jose,75));
        rtnList.add(new Book("Java Enterprise Patterns",jose,75));
        rtnList.add(new Book("Microservice Patterns with examples", jose,75));
        rtnList.add(new Book("Concurrency in Practice, Java",jose,75));

        return rtnList;
    }
}
