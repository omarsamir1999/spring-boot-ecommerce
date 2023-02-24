package com.luv2code.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


    @Entity
    @Table(name="order")
    @Getter
    @Setter
    public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String categoryName;

        @Column(name = "imageUrl")
        private String imageUrl;

        @Column(name = "quantity")
        private int quantity;

    }
