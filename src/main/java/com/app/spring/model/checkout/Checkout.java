package com.app.spring.model.checkout;

import com.app.spring.model.book.Book;
import com.app.spring.model.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hire")
@Data
@NoArgsConstructor
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "date_of_hire")
    private LocalDate dateOfHire;

    public Checkout(Book book, User user, LocalDate dateOfHire) {
        this.book = book;
        this.user = user;

        this.dateOfHire = dateOfHire;

    }
}
