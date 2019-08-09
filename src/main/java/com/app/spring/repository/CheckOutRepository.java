package com.app.spring.repository;

import com.app.spring.model.checkout.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckOutRepository extends JpaRepository<Checkout, Integer> {
}
