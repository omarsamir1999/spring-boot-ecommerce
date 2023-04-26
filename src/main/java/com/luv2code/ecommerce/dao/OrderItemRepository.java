package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    //    @Query("FROM OrderItem WHERE CAST(categoryId AS integer) = :categoryId")
//    List<OrderItem> fetchOrder(Long categoryId);
    List<OrderItem> findByOrderOrderId(Long orderId);

}
