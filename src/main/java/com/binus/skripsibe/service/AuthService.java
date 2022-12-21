package com.binus.skripsibe.service;

import com.binus.skripsibe.dto.AuthRequest;
import com.binus.skripsibe.dto.LoginDTO;
import com.binus.skripsibe.dto.UserDTO;

public interface AuthService {
    UserDTO register(AuthRequest user);

    LoginDTO login(AuthRequest user);

}
