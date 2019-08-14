package com.app.spring.repository;

import com.app.spring.model.book.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findBooksByAuthorLastName(String name);

    List<Book> findBookByTitle(String title);


}
