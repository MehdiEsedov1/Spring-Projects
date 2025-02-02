package com.example.ecommerceexam.service.impl;

import com.example.ecommerceexam.mapper.UserMapper;
import com.example.ecommerceexam.model.dto.request.UserRequest;
import com.example.ecommerceexam.model.entity.Cart;
import com.example.ecommerceexam.model.entity.Users;
import com.example.ecommerceexam.repository.CartRepo;
import com.example.ecommerceexam.repository.UserRepo;
import com.example.ecommerceexam.service.CartService;
import com.example.ecommerceexam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepo userRepo;
    private final CartService cartService;
    private final CartRepo cartRepo;

    @Override
    public String logIn(UserRequest userRequest) {
        Optional<Users> user = userRepo.findById(userRequest.getId());
        if (user.isPresent()) {
            return "Log in successfully!";
        } else {
            return "This account doesn't exit!";
        }
    }

    @Override
    public String signUp(UserRequest userRequest) {
        Optional<Users> exitingUser = userRepo.findById(userRequest.getId());
        if (exitingUser.isPresent()) {
            return "This account has already signed up!";
        } else {
            Cart cart = cartService.createCart();
            Users newUser = userMapper.map(userRequest);
            newUser.setCart(cart);
            userRepo.save(newUser);
            return "Signed up successfully!";
        }
    }
}