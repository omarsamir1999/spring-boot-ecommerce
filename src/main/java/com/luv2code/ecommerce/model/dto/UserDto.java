package com.luv2code.ecommerce.model.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;

    private String name;
    private String email;

    private String phone;

    private String address;
}
