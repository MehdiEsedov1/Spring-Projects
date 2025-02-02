package com.example.ecommerceexam.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String productDetails;
    private String description;
    private Integer amount;
    private Integer remainCount;
    @OneToOne
    private Brand brand;
    @OneToOne
    private Category category;
}