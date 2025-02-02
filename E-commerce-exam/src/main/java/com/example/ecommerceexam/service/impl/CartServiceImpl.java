package com.example.ecommerceexam.service.impl;

import com.example.ecommerceexam.mapper.ProductMapper;
import com.example.ecommerceexam.model.dto.request.CartRequest;
import com.example.ecommerceexam.model.entity.Cart;
import com.example.ecommerceexam.model.entity.Product;
import com.example.ecommerceexam.repository.CartRepo;
import com.example.ecommerceexam.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepo cartRepo;
    private final ProductMapper productMapper;

    @Override
    public Cart createCart() {

        Cart cart = new Cart();
        cart.setTotalAmount(0L);
        cart.setCountOfProduct(0L);
        cart.setProduct(null);
        cartRepo.save(cart);

        return cart;
    }

    @Override
    public void addProductToCart(Long id, CartRequest cartRequest) {
        Cart cart = cartRepo.findById(id).orElseThrow();
        List<Long> productIds = cartRequest.getIds();

        List<Product> products = productIds.stream()
                .map(productId -> {
                    Product product = new Product();
                    product.setId(productId);
                    return product;
                })
                .collect(Collectors.toList());

        cart.setProduct(products);
        cartRepo.save(cart);
    }
}