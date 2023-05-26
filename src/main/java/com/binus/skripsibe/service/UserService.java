package com.binus.skripsibe.service;

import com.binus.skripsibe.dto.AuthRequest;
import com.binus.skripsibe.entity.UserDetail;

public interface UserService {
    void addUserDetail(UserDetail userDetail);
    void addNewUser(AuthRequest authRequest);
}
