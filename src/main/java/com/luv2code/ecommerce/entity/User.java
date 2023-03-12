package com.luv2code.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String email;

    private String phone;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}
