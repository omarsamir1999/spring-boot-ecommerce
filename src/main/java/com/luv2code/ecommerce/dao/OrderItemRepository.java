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
    @Query("SELECT oi FROM OrderItem oi WHERE oi.product.categoryId = :categoryId AND oi.order.orderStatus IN ('undelivered', 'delivery')")
    List<OrderItem> findUndeliveredOrPartiallyDeliveredOrdersByCategoryId(Long categoryId);

    List<OrderItem> findByOrderOrderId(Long orderId);

}
