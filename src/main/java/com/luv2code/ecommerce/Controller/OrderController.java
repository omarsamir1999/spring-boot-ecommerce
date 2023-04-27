package com.luv2code.ecommerce.Controller;
import com.luv2code.ecommerce.dao.ListOrderRepository;
import com.luv2code.ecommerce.entity.Order;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class OrderController {

    @Autowired
    private ListOrderRepository orderRepository;

    @GetMapping("orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {

        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("orders/add")
    public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order) {
        orderRepository.save(order);
        return ResponseEntity.ok(order);
    }

//    @GetMapping("orders/active")
//    public ResponseEntity<List<Order>> getActiveOrders() {
//        List<Order> activeOrders = orderRepository.fetchListOrder();
//        return ResponseEntity.ok(activeOrders);
//    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long orderId,
                                             @Valid @RequestBody Order orderDetails) throws ResourceNotFoundException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));

        order.setOrderStatus(orderDetails.getOrderStatus());


        final Order updatedOrder = orderRepository.save(order);
        return ResponseEntity.ok(updatedOrder);
    }

}