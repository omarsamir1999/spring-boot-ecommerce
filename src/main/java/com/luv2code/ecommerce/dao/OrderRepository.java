package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("FROM OrderEntity WHERE CAST(categoryId AS integer) = :categoryId")
    List<OrderEntity> fetchOrder(Long categoryId);
}
