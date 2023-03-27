package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.dao.ProductRepository;
import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @GetMapping("product")
    List<Product> all() {
        return productRepository.findAll();
    }

    @GetMapping("product/search")
    public ResponseEntity<List<Product>> searchByName(@RequestParam("qq") String name) {
        List<Product> products = productService.findByNameContainingIgnoreCase(name);
        return ResponseEntity.ok(products);
    }

    @PostMapping("product/add")
    public Product addTask(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }
}
