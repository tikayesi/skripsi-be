package com.binus.skripsibe.service.impl;

import com.binus.skripsibe.dto.UserDetailsImpl;
import com.binus.skripsibe.entity.User;
import com.binus.skripsibe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserServiceImpl implements UserDetailsService {

    private final UserRepository appUserRepository;

    @Autowired
    public CustomUserServiceImpl(UserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> appUser = appUserRepository.findByUsername(username);
        if (!appUser.isPresent()) {
            try {
                throw new Exception("user not found");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return new UserDetailsImpl(appUser.get());
    }


}
