package com.app.spring.controller;

import com.app.spring.model.author.Author;
import com.app.spring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    public AuthorService service;

    @GetMapping("/author/{id}")
    public Optional<Author> GetAllBooks(@PathVariable("id") int id) {
        return service.GetAllBooks((id));
    }
}
