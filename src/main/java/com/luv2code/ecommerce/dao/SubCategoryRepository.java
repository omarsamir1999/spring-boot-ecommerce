package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.SubCategory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

}
