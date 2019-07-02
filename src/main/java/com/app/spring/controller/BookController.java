package com.app.spring.controller;

import com.app.spring.data.Book;
import com.app.spring.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    private BookRepository bookService;

    public BookController(BookRepository bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> book() {
        List<Book> books = new ArrayList<>();
        bookService.findAll().forEach(books::add);
        return books;
    }

    @PostMapping(value = "/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping(value = "/book")
    public List<Book> booksByAuthorLastName(@RequestParam("name") String name) {
        return bookService.findBooksByAuthorLastName(name);
    }
}
