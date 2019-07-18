package com.app.spring.repository;

import com.app.spring.model.book.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    @Query("SELECT b from Book b where b.authorLastName =:name")
    List<Book> findBooksByAuthorLastName(@Param("name") String name);

    @Query("SELECT b from Book b where b.title =:title")
    List<Book> findBookByTitle(@Param("title") String title);


}
