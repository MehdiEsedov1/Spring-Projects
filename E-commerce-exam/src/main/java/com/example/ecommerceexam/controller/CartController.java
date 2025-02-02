package com.example.ecommerceexam.controller;

import com.example.ecommerceexam.model.dto.request.CartRequest;
import com.example.ecommerceexam.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "cart")
public class CartController {
    private final CartService cartService;

    @PostMapping(path = "/addProduct/{id}")
    void addProduct(@PathVariable Long id, @RequestBody @Valid CartRequest cartRequest) {
        cartService.addProductToCart(id, cartRequest);
    }
}