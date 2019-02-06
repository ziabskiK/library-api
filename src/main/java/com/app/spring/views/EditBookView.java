package com.app.spring.views;


import com.app.spring.implementation.BookService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "edit")
public class EditBookView extends VerticalLayout {

    @Autowired
    BookService service;
    private TextField titleTF;
    private TextField authorTF;
    public EditBookView() {


        titleTF = new TextField();


    }
}
