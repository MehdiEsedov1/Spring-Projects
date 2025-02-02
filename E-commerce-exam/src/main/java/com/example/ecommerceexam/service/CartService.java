package com.example.ecommerceexam.service;

import com.example.ecommerceexam.model.dto.request.CartRequest;
import com.example.ecommerceexam.model.entity.Cart;

public interface CartService {
    Cart createCart();
    void addProductToCart(Long id, CartRequest cartRequest);
}
