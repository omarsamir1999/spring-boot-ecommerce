package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.SellerRepository;
import com.luv2code.ecommerce.model.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public Seller getUserByUsername(String username) {
        return sellerRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with username: " + username));
    }
}
