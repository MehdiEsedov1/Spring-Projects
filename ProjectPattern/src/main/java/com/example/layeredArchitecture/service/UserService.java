package com.example.layeredArchitecture.service;

import com.example.layeredArchitecture.dto.User;

public interface UserService {
    User getUserById(Long userId);
}
