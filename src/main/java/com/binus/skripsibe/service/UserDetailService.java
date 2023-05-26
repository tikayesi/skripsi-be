package com.binus.skripsibe.service;

import com.binus.skripsibe.entity.UserDetail;

import java.util.List;

public interface UserDetailService {
    UserDetail getUserDetail(String id);
    List<UserDetail> getAllUserDetail();
    UserDetail addUserDetail(UserDetail userDetail);
    UserDetail update(UserDetail userDetail);
    void deleteUser(String id);
}
