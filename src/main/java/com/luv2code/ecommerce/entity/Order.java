package com.luv2code.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


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
        private String orderName;

        @Column(name = "imageUrl")
        private String imageUrl;

        @JsonBackReference
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "list_order_id" ,referencedColumnName="id")
        private ListOrder listOrder;

    }
