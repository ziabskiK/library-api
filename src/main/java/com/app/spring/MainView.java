package com.app.spring;

import com.app.spring.data.Book;
import com.app.spring.implementation.BookServiceImplementation;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "home")
public class MainView extends VerticalLayout {


    private Button searchForCustomers ;
    private Button addNewCustomer ;


    public MainView(@Autowired BookServiceImplementation service) {

        //HorizontalLayout layout = new HorizontalLayout();

        setupLayout();

        List<Book> customers = service.findAll();
        VerticalLayout bookLayout = new VerticalLayout();

        bookLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        searchForCustomers.addClickListener(click -> {
            remove(bookLayout);
            bookLayout.removeAll();
            customers.forEach(customer ->
                    bookLayout.add(new Label(customer.toString())));
            add(bookLayout);

        });

      //  add(label, layout);


    }
    private void setupLayout(){
        HorizontalLayout layout = new HorizontalLayout();

        Label label = new Label("Welcome in basic CRUD application using Spring and Vaadin!");
        label.setHeight("20");

        searchForCustomers = new Button("Search for books");
        addNewCustomer = new Button("Add new book");

        layout.add(searchForCustomers, addNewCustomer);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setAlignItems(Alignment.CENTER);
        this.add(label, layout);


    }

    private void searchBooks(){

    }

}
