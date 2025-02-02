package com.example.user_manegement_system.mapper.impl;

import com.example.user_manegement_system.mapper.UserMapper;
import com.example.user_manegement_system.model.dto.request.UserRequest;
import com.example.user_manegement_system.model.entity.Users;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public Users map(UserRequest request) {
        return Users.
                builder()
                .email(request.getEmail())
                .name(request.getName())
                .surname(request.getSurname())
                .password(request.getPassword())
                .build();
    }
}