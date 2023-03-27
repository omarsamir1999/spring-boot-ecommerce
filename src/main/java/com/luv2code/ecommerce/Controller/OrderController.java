package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.dao.OrderRepository;
import com.luv2code.ecommerce.entity.Order;
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

    @GetMapping("order")
    List<Order> all() {
        return orderRepository.findAll();
    }

    @GetMapping("/order/{id}")
    Order one(@PathVariable Long id) {

        return orderRepository.findById(id).orElse(null);
    }


    @PostMapping("order/add")
    public Order addTask(@Valid @RequestBody Order order) {
        return orderRepository.save(order);
    }

}
