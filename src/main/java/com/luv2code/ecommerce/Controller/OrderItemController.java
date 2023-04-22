package com.luv2code.ecommerce.Controller;
import com.luv2code.ecommerce.dao.OrderRepository;
import com.luv2code.ecommerce.entity.OrderItem;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class OrderItemController {

    @Autowired
    private OrderRepository orderRepository;


//    @GetMapping("order/active/{categoryId}")
//    List<OrderItem> findByStatus(@PathVariable Long categoryId) {
//        return orderRepository.fetchOrder(categoryId);
//    }
    @GetMapping("order")
    List<OrderItem> all() {
        return orderRepository.findAll();
    }

    @GetMapping("order/{id}")
    OrderItem one(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }



    @PostMapping("order/add")
    public OrderItem addOrder(@Valid @RequestBody OrderItem order) {
        return orderRepository.save(order);
    }
}