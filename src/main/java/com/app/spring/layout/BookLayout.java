package com.app.spring.layout;

import com.app.spring.implementation.BookServiceImplementation;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

public class BookLayout extends VerticalLayout {


    @Autowired
    BookServiceImplementation service;

    public BookLayout() {

    }



}
