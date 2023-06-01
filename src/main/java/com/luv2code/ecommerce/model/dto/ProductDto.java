package com.luv2code.ecommerce.model.dto;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class ProductDto {

    private String name;


    private BigDecimal price;


    private Long categoryId;

    private String imageUrl;
}
