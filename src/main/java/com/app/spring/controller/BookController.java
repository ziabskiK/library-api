package com.app.spring.controller;

import com.app.spring.exception.BookNotFoundException;
import com.app.spring.model.book.Book;
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

    @GetMapping(value = "/book/author")
    public List<Book> booksByAuthorLastName(@RequestParam("author") String author) {
        return bookService.findBooksByAuthorLastName(author);
    }

    @GetMapping(value = "/book/title")
    public List<Book> booksByTitle(@RequestParam("title") String title) {
        return bookService.findBookByTitle(title);
    }

    @GetMapping(value = "/book/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookService.findById(id).orElseThrow(() -> new BookNotFoundException(id));

    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin logged in";
    }

    @GetMapping("/user")
    public String user() {
        return "User logged in";
    }

}
