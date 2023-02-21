package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.dao.CategoryRepository;
import com.luv2code.ecommerce.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping("count-users")
    public String getCountUsers(){
        long numberUsers = categoryRepository.count();
        return "Number of users = "+numberUsers;
    }

    @PostMapping("/add")
    public Category addTask(@Valid @RequestBody Category category){
        return categoryRepository.save(category);
    }
    @GetMapping("add-user")
    public String addUser(){
        Category user = new Category();
        user.setCategoryName("Render");
        user.setImageUrl("Render");
        user.setId(1L);
        categoryRepository.save(user);
        return "User added successfully";
    }
}
