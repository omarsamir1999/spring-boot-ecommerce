package com.luv2code.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;


@Entity
    @Table(name="order")
    @Getter
    @Setter
    public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(name = "product")
        List<Product> products;
        @Column(name = "quantity")
        private int quantity;

    }
