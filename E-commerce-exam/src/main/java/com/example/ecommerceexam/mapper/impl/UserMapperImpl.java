package com.example.ecommerceexam.mapper.impl;

import com.example.ecommerceexam.mapper.UserMapper;
import com.example.ecommerceexam.model.dto.request.UserRequest;
import com.example.ecommerceexam.model.dto.response.UserResponse;
import com.example.ecommerceexam.model.entity.Users;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponse map(Users user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .address(user.getAddress())
                .surname(user.getSurname())
                .birthdate(user.getBirthdate())
                .build();
    }

    @Override
    public Users map(UserRequest userRequest) {
        return Users.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .address(userRequest.getAddress())
                .surname(userRequest.getSurname())
                .birthdate(userRequest.getBirthdate())
                .build();
    }
}