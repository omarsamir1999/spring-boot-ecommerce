package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.dao.ProductRepository;

import com.luv2code.ecommerce.entity.Order;
import com.luv2code.ecommerce.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("product")
    List<Product> all() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    Product one(@PathVariable Long id) {

        return productRepository.findById(id).orElse(null);
    }

    @GetMapping("/product/subCategory/{id}")
    List<Product> findBySubCate(@PathVariable Long id) {
        return productRepository.fetchProduct(id);
    }

    @PostMapping("product/add")
    public Product addTask(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }
}
