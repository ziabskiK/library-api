package com.app.spring.service;

import com.app.spring.model.author.Author;
import com.app.spring.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    public AuthorRepository repository;

    public Optional<Author> GetAllBooks(int id) {
        return repository.findById(id);
    }
}
