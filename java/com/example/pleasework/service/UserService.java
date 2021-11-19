package com.example.pleasework.service;

import com.example.pleasework.dto.UserRegistrationDto;
import com.example.pleasework.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto userRegistrationDto);
}
