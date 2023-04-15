package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.dao.OrderRepository;
import com.luv2code.ecommerce.entity.ListOrder;
import com.luv2code.ecommerce.entity.OrderEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("order/active/{categoryId}")
    List<OrderEntity> findByStatus(@PathVariable Long categoryId) {
        return orderRepository.fetchOrder(categoryId);
    }
    @GetMapping("order")
    List<OrderEntity> all() {
        return orderRepository.findAll();
    }

    @GetMapping("order/{id}")
    OrderEntity one(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }



    @PostMapping("order/add")
    public OrderEntity addOrder(@Valid @RequestBody OrderEntity order) {
        return orderRepository.save(order);
    }
}