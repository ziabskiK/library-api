package com.app.spring.implementation;

import com.app.spring.data.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookList {
    final
    BookServiceImplementation service;

    @Autowired
    public BookList(BookServiceImplementation service) {
        this.service = service;
    }

    public List<Book> bookList(){
        return service.findAll();
    }
}
