//package com.luv2code.ecommerce.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.experimental.Accessors;
//
//import java.math.BigDecimal;
//
//
//
//@Entity
//@Table(name = "order_items")
//@Data
//public class OrderItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long itemId;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    private Integer quantity;
//
//    private BigDecimal price;
//
//    // constructors, getters and setters
//}

package com.luv2code.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    private BigDecimal price;

    public OrderItem(Product product, Integer quantity, BigDecimal price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}
