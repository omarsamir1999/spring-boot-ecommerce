package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.CategoryRepository;
import com.luv2code.ecommerce.model.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
