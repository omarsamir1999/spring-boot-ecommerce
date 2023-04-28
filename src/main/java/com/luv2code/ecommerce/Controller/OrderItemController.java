package com.luv2code.ecommerce.Controller;
import com.luv2code.ecommerce.dao.ListOrderRepository;
import com.luv2code.ecommerce.dao.OrderItemRepository;
import com.luv2code.ecommerce.entity.Order;
import com.luv2code.ecommerce.entity.OrderItem;
import com.luv2code.ecommerce.service.OrderItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
    private ListOrderRepository listOrderRepository;

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



    @GetMapping("order/cate/{categoryId}")
    public ResponseEntity<List<OrderItem>> getActiveOrders(@PathVariable  Long categoryId) {
        List<OrderItem> orderItems =orderRepository.fetchCategoryId(categoryId);
        return ResponseEntity.ok(orderItems);
    }

    @PostMapping("order/add")
    public OrderItem addOrder(@Valid @RequestBody OrderItem order) {
        return orderRepository.save(order);
    }

    @PutMapping("order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long orderId,
                                             @Valid @RequestBody Order orderDetails) throws ResourceNotFoundException {
        Order order = listOrderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));

        order.setOrderStatus(orderDetails.getOrderStatus());


        final Order updatedOrder = listOrderRepository.save(order);
        return ResponseEntity.ok(updatedOrder);
    }
}