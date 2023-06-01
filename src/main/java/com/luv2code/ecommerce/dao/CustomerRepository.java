package com.luv2code.ecommerce.dao;

import java.util.Optional;

import com.luv2code.ecommerce.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);

}
