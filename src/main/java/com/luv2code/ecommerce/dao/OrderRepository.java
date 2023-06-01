package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query("SELECT o FROM Order o JOIN o.orderItems oi JOIN oi.product p WHERE p.categoryName = 'Super'")
    List<Order> fetchListOrder();


}
