package com.example.ecommerceexam.mapper;

import com.example.ecommerceexam.model.dto.request.UserRequest;
import com.example.ecommerceexam.model.dto.response.UserResponse;
import com.example.ecommerceexam.model.entity.Users;

public interface UserMapper {
    UserResponse map(Users user);

    Users map(UserRequest userRequest);
}
