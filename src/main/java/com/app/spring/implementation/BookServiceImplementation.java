package com.app.spring.implementation;

import com.app.spring.data.Book;
import com.app.spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation {

    private BookRepository repository;

    @Autowired
    public BookServiceImplementation(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll(){
        return repository.findAll();
    }
}
