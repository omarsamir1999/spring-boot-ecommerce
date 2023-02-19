package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.dao.CategoryRepository;
import com.luv2code.ecommerce.entity.Category;
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
    @GetMapping("count-users")
    public String getCountUsers(){
        long numberUsers = categoryRepository.count();
        return "Number of users = "+numberUsers;
    }

    @GetMapping("add-user")
    public String addUser(){
        Category user = new Category();
        user.setCategoryName("سوبر ماركت");
        user.setId(1L);
        user.setImageUrl("image2");
        categoryRepository.save(user);
        return "User added successfully";
    }
}
