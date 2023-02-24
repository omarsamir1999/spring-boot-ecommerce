package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.dao.OrderRepository;
import com.luv2code.ecommerce.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class ListOrderController {


    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("listOrder")
    List<Order> all() {
        return orderRepository.findAll();
    }

    @GetMapping("listOrder/{id}")
    Order one(@PathVariable Long id) {

        return orderRepository.findById(id).orElse(null);
    }


}
