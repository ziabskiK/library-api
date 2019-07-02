package com.app.spring.controller;

import com.app.spring.repository.BookRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class BookControllerTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookController bookController;


    @Test
    public void get_all_books() {


    }

    @Test
    public void add_new_book() {
    }
}