package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderItem, Long> {
//    @Query("FROM OrderItem WHERE CAST(categoryId AS integer) = :categoryId")
//    List<OrderItem> fetchOrder(Long categoryId);
}
