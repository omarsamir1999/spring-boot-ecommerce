package com.luv2code.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Entity
@Table(name="category")
// @Data -- known bug
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String categoryName;

    @Column(name = "imageurl")
    private String imageUrl;


    @OneToMany(mappedBy = "category")
    private List<SubCategory> subCategory;


}







