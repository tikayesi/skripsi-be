package com.binus.skripsibe.service.impl;

import com.binus.skripsibe.entity.UserDetail;
import com.binus.skripsibe.repository.UserDetailRepository;
import com.binus.skripsibe.service.UserDetailService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserDetailServiceImpl implements UserDetailService {

    UserDetailRepository userDetailRepository;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public UserDetail getUserDetail(String id) {
        return userDetailRepository.findById(id).get();
    }

    @Override
    public List<UserDetail> getAllUserDetail() {
        return userDetailRepository.findAll();
    }

    @Override
    public UserDetail addUserDetail(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    @Override
    public UserDetail update(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    @Override
    public void deleteUser(String id) {
        userDetailRepository.deleteById(id);
    }
}
