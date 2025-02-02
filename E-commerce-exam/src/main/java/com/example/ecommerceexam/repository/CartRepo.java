package com.example.ecommerceexam.repository;

import com.example.ecommerceexam.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {
}