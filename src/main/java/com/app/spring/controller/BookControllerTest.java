package com.app.spring.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
public class BookControllerTest {

    @Test
    public void should_add_two_numbers() {
        assertEquals(2 + 2, 4);
    }


}