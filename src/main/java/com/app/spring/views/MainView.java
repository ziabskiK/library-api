package com.app.spring.views;

import com.app.spring.data.Book;
import com.app.spring.implementation.BookList;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Route(value = "home")
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class MainView extends VerticalLayout {


    @Autowired
    private BookList bookList;

    private VerticalLayout bookLayout;

    public MainView() {


        setupLayout();

    }

    private void setupLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        bookLayout = new VerticalLayout();

        Label label = new Label("Welcome in basic CRUD application using Spring and Vaadin!");
        label.setHeight("20");

        Button searchForCustomers = new Button("Search for books", click -> searchBooks());
        Button addNewCustomer = new Button("Add new book", click -> navigate());

        layout.add(searchForCustomers, addNewCustomer);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setAlignItems(Alignment.CENTER);


        this.add(label, layout);




    }

    private void searchBooks() {

        List<Book> customers = bookList.bookList();


//        bookLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
//        bookLayout.removeAll();
//        customers.forEach(customer ->
//                bookLayout.add(new Label(customer.toString())));
//        this.add(bookLayout);

        Grid<Book> grid = new Grid<>();
        grid.setItems(customers);
        grid.addColumn(Book::getTitle).setHeader("Title");
        grid.addColumn(Book::getAuthorFirstName).setHeader("Author first name");
        grid.addColumn(Book::getAuthorLastName).setHeader("Author last name");


        add(grid);
    }

    private void navigate() {
        Optional optional = getUI();
        if (optional.isPresent()) {
            getUI().get().navigate("add");
        }
    }

}
