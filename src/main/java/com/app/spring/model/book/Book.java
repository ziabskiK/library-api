package com.app.spring.model.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;


    @Column(name = "author_first_name")
    private String authorFirstName;

    @Column(name = "author_last_name")
    private String authorLastName;


    public Book(String authorLastName, String authorFirstName, String title) {
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;

    }

}
