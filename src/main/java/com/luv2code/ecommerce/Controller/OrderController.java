package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.dao.OrderRepository;
import com.luv2code.ecommerce.entity.OrderEntity;
import com.luv2code.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @GetMapping("/{categoryId}")
    public ResponseEntity<List<OrderEntity>> getProductsByCategoryId(@PathVariable Long categoryId) {
        List<OrderEntity> orderEntities = orderService.getProductsByCategoryId(categoryId);
        return new ResponseEntity<>(orderEntities, HttpStatus.OK);
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