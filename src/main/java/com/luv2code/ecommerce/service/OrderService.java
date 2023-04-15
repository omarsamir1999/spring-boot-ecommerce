package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.OrderRepository;
import com.luv2code.ecommerce.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderEntity> getProductsByCategoryId(Long categoryId) {
        return orderRepository.findByCategoryId(categoryId);
    }
}
