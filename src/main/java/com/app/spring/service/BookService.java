package com.app.spring.service;

import com.app.spring.exception.BookNotFoundException;
import com.app.spring.model.book.Book;
import com.app.spring.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findBooksByAuthor(String authorLastName) {
        return bookRepository.findBooksByAuthorLastName(authorLastName);
    }

    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

    }
}
