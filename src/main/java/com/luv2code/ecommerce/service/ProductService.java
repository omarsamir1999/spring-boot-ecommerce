package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.entity.Product;

import java.util.List;

public interface  ProductService {
    List<Product> findByNameContainingIgnoreCase(String name);
}
