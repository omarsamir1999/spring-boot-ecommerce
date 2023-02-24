package com.luv2code.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

        @JsonIgnore
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "list_order_id")
        private ListOrder listOrder;

    }
