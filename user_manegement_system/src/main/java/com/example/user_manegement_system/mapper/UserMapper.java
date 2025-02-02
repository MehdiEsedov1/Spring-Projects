package com.example.user_manegement_system.mapper;

import com.example.user_manegement_system.model.dto.request.UserRequest;
import com.example.user_manegement_system.model.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper {
    Users map(UserRequest request);
}