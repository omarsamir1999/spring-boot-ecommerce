package com.luv2code.ecommerce.model.dto;

import com.luv2code.ecommerce.model.entity.Product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {

    private Long id;

    private Product product;

    private Integer quantity;

    private BigDecimal price;
}
