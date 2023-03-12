package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.dao.SubCategoryRepository;
import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class SubCategoryController {

    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @GetMapping("SubCategory")
    List<SubCategory> all() {
        return subCategoryRepository.findAll();
    }

    @GetMapping("/SubCategory/{id}")
    SubCategory one(@PathVariable Long id) {

        return subCategoryRepository.findById(id).orElse(null);
    }


}
