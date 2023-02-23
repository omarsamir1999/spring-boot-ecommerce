package com.luv2code.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;


    @Entity
    @Table(name="order")
// @Data -- known bug
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
