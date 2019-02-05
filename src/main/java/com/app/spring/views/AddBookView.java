package com.app.spring.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Optional;

@Route(value = "add")
public class AddBookView extends VerticalLayout {
    public AddBookView() {
        add(new Label("TEST"));
        add(new Button("Go to home", e-> navigateToHome()));
    }

    private void navigateToHome(){
        Optional o = getUI();
        if (o.isPresent()){
            getUI().get().navigate("home");
        }
    }
}
