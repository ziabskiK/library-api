package com.app.spring.views;

import com.app.spring.data.Book;
import com.app.spring.implementation.BookService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.editor.Editor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Route(value = "home")
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class MainView extends VerticalLayout {


    @Autowired
    private BookService bookList;

    private Button searchForCustomers;
    private Grid<Book> grid;

    public MainView() {


        setupLayout();

    }

    private void setupLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        VerticalLayout bookLayout = new VerticalLayout();

        Label label = new Label("Welcome in basic CRUD application using Spring and Vaadin!");
        label.setHeight("20");

        Button searchForCustomers = new Button("Search for books", click -> searchBooks());
        searchForCustomers.setDisableOnClick(true);
        Button addNewCustomer = new Button("Add new book", click -> navigateToAddNewBook());

        layout.add(searchForCustomers, addNewCustomer);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setAlignItems(Alignment.CENTER);


        this.add(label, layout);




    }

    private void searchBooks() {
        grid = new Grid<>();

        List<Book> customers = bookList.findAll();

//        bookLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
//        bookLayout.removeAll();
//        customers.forEach(customer ->
//                bookLayout.add(new Label(customer.toString())));
//        this.add(bookLayout);

        grid.setItems(customers);
        Grid.Column<Book> titleColumn = grid.addColumn(Book::getTitle).setHeader("Title").setWidth("25%");
        Grid.Column<Book> firstNameCol = grid.addColumn(Book::getAuthorFirstName).setHeader("Author first name").setWidth("33%");
        Grid.Column<Book> lastNameCol = grid.addColumn(Book::getAuthorLastName).setHeader("Author last name").setWidth("33%");
        Grid.Column<Book> editCol = grid.addColumn(new NativeButtonRenderer<Book>("Edit", c-> edit())).setWidth("9%");




        add(grid);

    }

    private void navigateToAddNewBook() {
        Optional optional = getUI();
        if (optional.isPresent()) {
            getUI().get().navigate("add");
        }
    }
    private void edit(){
        Binder<Book> binder = new Binder<>(Book.class);
        Editor<Book> edditor = grid.getEditor();
        edditor.setBinder(binder);
        edditor.setBuffered(true);
        TextField textField = new TextField();


    }


}
