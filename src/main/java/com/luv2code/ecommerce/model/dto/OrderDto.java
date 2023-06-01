package com.luv2code.ecommerce.model.dto;

import com.luv2code.ecommerce.model.entity.Customer;
import com.luv2code.ecommerce.model.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Customer users;
    private String orderStatus;
    private List<OrderItem> orderItems;



}

