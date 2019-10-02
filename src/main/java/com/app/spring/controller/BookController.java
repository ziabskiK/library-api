package com.app.spring.controller;

import com.app.spring.model.book.Book;
import com.app.spring.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> book() {
        return bookService.findAllBooks();
    }

    @PostMapping(value = "/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }


    @GetMapping(value = "/book/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookService.getBookById(id);

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
