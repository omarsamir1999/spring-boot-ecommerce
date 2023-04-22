package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubCategoryRepository extends JpaRepository<Subcategory, Long> {

}
