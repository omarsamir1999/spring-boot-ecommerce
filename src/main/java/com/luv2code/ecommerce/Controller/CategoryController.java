package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.dao.CategoryRepository;
import com.luv2code.ecommerce.entity.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("category")
    List<Category> all() {
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    Category one(@PathVariable Long id) {

        return categoryRepository.findById(id).orElse(null);
    }


    @PostMapping("category/add")
    public Category addTask(@Valid @RequestBody Category category){
        return categoryRepository.save(category);
    }

}
