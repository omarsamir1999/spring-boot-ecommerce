package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Order;
import com.luv2code.ecommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Query("SELECT i FROM OrderItem i WHERE i.product.categoryId = :categoryId")
    List<OrderItem> fetchCategoryId(Long categoryId);

    List<OrderItem> findByOrderOrderId(Long orderId);

}
