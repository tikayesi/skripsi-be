package com.binus.skripsibe.service.impl;

import com.binus.skripsibe.dto.AuthRequest;
import com.binus.skripsibe.entity.UserDetail;
import com.binus.skripsibe.repository.UserDetailRepository;
import com.binus.skripsibe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserDetailRepository userDetailRepository;

    @Autowired
    public UserServiceImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public void addUserDetail(UserDetail userDetail) {
        userDetailRepository.save(userDetail);
    }

    @Override
    public void addNewUser(AuthRequest authRequest) {

    }
}
