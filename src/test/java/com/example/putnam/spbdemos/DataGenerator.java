package com.example.putnam.spbdemos;

import java.util.ArrayList;
import java.util.List;

import com.example.putnam.spbdemos.domain.Author;
import com.example.putnam.spbdemos.domain.Book;

public class DataGenerator {

    public static List<Book> getSampleBooks() {
        
        ArrayList<Book> rtnList = new ArrayList<>();
        Author mark = new Author("Mark","Twain");
        Author janet = new Author("Jane","Java");

        rtnList.add(new Book("Welcome to the Jungle", mark, 42));
        rtnList.add(new Book("Spring Love You!", janet, 42));
        rtnList.add(new Book("Dynamic Configuration rocks", mark, 23));



        return rtnList;
    }
}
