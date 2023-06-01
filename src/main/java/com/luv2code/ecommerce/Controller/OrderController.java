package com.luv2code.ecommerce.Controller;
import com.luv2code.ecommerce.model.entity.Order;
import com.luv2code.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public List<Order> getAllOrder() {
        List<Order> orders = orderService.getAllOrder();
        System.out.println(OrderService.calculateOrderTotal(orders));
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("")
    public Order addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return order;
    }
    @GetMapping("/super")
    public List<Order> getAllSuperOrders() {
        return orderService.getAllSuperOrders();
    }
    @DeleteMapping("/{id}")
    public String deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return "Order with ID " + id + " has been deleted";
    }

}