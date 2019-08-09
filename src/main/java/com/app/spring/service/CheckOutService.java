package com.app.spring.service;

import com.app.spring.model.book.Book;
import com.app.spring.model.checkout.Checkout;
import com.app.spring.model.user.User;
import com.app.spring.repository.CheckOutRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CheckOutService {

    private final CheckOutRepository repository;
    private final BookService bookService;

    @Autowired
    public CheckOutService(CheckOutRepository repository, BookService bookService) {
        this.repository = repository;
        this.bookService = bookService;
    }

    public Checkout createCheckout(ObjectNode json) {
        User user = userParser(json.get("token").asText());
        int book_id = json.get("book").asInt();
        Book book = bookService.getBookById(book_id);
        LocalDate date = LocalDate.now();


        return repository.save(new Checkout(book, user, date));
    }

    private User userParser(String token) {
        DecodedJWT jwt = JWT.decode(token);
        Long id = jwt.getClaim("id").asLong();
        String email = jwt.getClaim("email").asString();
        String firstName = jwt.getClaim("firstName").asString();
        String lastName = jwt.getClaim("lastName").asString();


        User user = new User(email, firstName, lastName);

        user.setId(id);

        return user;

    }
}
