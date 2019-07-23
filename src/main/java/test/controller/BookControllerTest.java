package test.controller;


import com.app.spring.model.book.Book;
import com.app.spring.repository.BookRepository;
import com.app.spring.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = BookService.class)

@RunWith(SpringRunner.class)
public class BookControllerTest {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository repository;


    @Test
    public void shouldReturnListOfBooks() {

        when(repository.findAll()).thenReturn(Stream.of(new Book("Mroz", "Remigiusz", "Kasacja"),
                new Book("Kafka", "Franz", "Proces"))
                .collect(Collectors.toList()));

        assertEquals(2, bookService.findAllBooks().size());

    }


    @Test
    public void shouldReturnBookBytitle() {
        String title = "Proces";
        when(repository.findBookByTitle(title)).thenReturn(Stream.of(new Book("Kafka", "Franz", "Proces")).collect(Collectors.toList()));
        assertEquals(1, bookService.findBooksByTitle(title).size());
    }

    @Test
    public void shouldReturnBookByAuthorLastName() {
        String name = "Mroz";

        when(repository.findBooksByAuthorLastName(name)).thenReturn(Stream.of(
                new Book("Mroz", "Remigiusz", "Kasacja"),
                new Book("Mroz", "Remigiusz", "Inwigilacja"))
                .collect(Collectors.toList()));

        assertEquals(2, bookService.findBooksByAuthor(name).size());

    }


}