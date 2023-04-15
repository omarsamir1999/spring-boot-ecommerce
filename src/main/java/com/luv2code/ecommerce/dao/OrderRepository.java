package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("SELECT p FROM OrderEntity p WHERE p.categoryId = :categoryId")
    List<OrderEntity> findByCategoryId(@Param("categoryId") Long categoryId);
}
