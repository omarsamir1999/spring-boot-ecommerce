package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.ListOrder;
import com.luv2code.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ListOrderRepository extends JpaRepository<ListOrder, Long> {

}
