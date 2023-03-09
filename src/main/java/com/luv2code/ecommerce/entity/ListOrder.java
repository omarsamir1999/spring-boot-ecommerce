package com.luv2code.ecommerce.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="list_order")
// @Data -- known bug
@Getter
@Setter
public class ListOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "listOrder")
    private List<Order> orders;

}







