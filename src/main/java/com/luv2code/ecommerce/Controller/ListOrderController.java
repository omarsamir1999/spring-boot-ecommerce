package com.luv2code.ecommerce.Controller;


import com.luv2code.ecommerce.dao.ListOrderRepository;
import com.luv2code.ecommerce.entity.ListOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin
public class ListOrderController {


    @Autowired
    private ListOrderRepository listOrderRepository;

    @GetMapping("listOrder")
    List<ListOrder> all() {
        return listOrderRepository.findAll();
    }

    @GetMapping("listOrder/{id}")
    ListOrder one(@PathVariable Long id) {

        return listOrderRepository.findById(id).orElse(null);
    }

    @PostMapping("listOrder/add")
    public ListOrder addTask(@Valid @RequestBody ListOrder listOrder) {
        return listOrderRepository.save(listOrder);
    }

    @GetMapping("listOrder/active")
    List<ListOrder> findByStatus() {
        return listOrderRepository.fetchListOrder();
    }
}
