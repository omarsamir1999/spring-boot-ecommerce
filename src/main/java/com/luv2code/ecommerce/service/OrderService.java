package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.OrderRepository;
import com.luv2code.ecommerce.model.entity.Category;
import com.luv2code.ecommerce.model.entity.Order;
import com.luv2code.ecommerce.model.entity.OrderItem;
import com.luv2code.ecommerce.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getAllSuperOrders() {
        return orderRepository.fetchListOrder();
    }
    public static double calculateOrderTotal(List<Order> orders) {
        double total = 0.0;
        for (Order order : orders) {
            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem item : orderItems) {
                Product product = item.getProduct();
                int quantity = item.getQuantity();
                double price = product.getPrice();
                total += price * quantity;
            }
        }
        return total;
    }

}