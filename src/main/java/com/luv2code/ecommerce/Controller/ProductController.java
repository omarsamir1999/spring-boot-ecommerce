package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.model.entity.Product;
import com.luv2code.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@CrossOrigin
public class ProductController {


    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    List<Product> getAllProducts() {
        return productService.getAllProduct();
    }
    @GetMapping("/{id}")
    Product getProductById(@PathVariable Long id) {

        return productService.getProductById(id);
    }
    @PostMapping("")
    public Product addProduct(@Valid @RequestBody Product product) {
         productService.addProduct(product);
         return product;
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "Department with ID " + id + " has been deleted";
    }
}
