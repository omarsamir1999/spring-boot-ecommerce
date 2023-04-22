package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListOrderRepository extends JpaRepository<Order, Long> {

    @Query("FROM Order WHERE  status = 'false' ")
    List<Order> fetchListOrder();
}
