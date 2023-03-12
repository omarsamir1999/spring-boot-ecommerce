package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;

import com.luv2code.ecommerce.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("FROM Product WHERE sub_category_id =:id ")
    List<Product> fetchProduct(Long id);

}
