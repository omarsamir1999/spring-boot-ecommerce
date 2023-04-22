package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.dao.SubCategoryRepository;
import com.luv2code.ecommerce.entity.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class SubCategoryController {

    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @GetMapping("SubCategory")
    List<Subcategory> all() {
        return subCategoryRepository.findAll();
    }

    @GetMapping("/SubCategory/{id}")
    Subcategory one(@PathVariable Long id) {

        return subCategoryRepository.findById(id).orElse(null);
    }


}
