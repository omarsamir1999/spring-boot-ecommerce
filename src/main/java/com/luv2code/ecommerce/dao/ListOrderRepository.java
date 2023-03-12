package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.ListOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListOrderRepository extends JpaRepository<ListOrder, Long> {

    @Query("FROM ListOrder WHERE  status = 'false' ")
    List<ListOrder> fetchListOrder();
}
