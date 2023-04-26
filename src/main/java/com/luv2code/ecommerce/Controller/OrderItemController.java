package com.luv2code.ecommerce.Controller;
import com.luv2code.ecommerce.dao.OrderItemRepository;
import com.luv2code.ecommerce.entity.OrderItem;
import com.luv2code.ecommerce.service.OrderItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderRepository;

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("orderItems/{orderId}")
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderId(orderId);
        return ResponseEntity.ok(orderItems);
    }
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