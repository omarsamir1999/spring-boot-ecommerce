package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.model.entity.Customer;
import com.luv2code.ecommerce.model.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller,Integer> {
    Optional<Seller> findByEmail(String email);
}
