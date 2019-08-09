package com.app.spring.controller;

import com.app.spring.model.checkout.Checkout;
import com.app.spring.service.CheckOutService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CheckOutController {

    private final CheckOutService checkOutService;

    @Autowired
    public CheckOutController(CheckOutService checkOutService) {
        this.checkOutService = checkOutService;
    }

    @PostMapping("/hire")
    public Checkout createHire(@RequestBody ObjectNode json) {
        return checkOutService.createCheckout(json);
    }
}
