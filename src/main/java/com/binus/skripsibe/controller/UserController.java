package com.binus.skripsibe.controller;

import com.binus.skripsibe.entity.UserDetail;
import com.binus.skripsibe.service.UserDetailService;
import com.binus.skripsibe.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    UserDetailService userService;

    @Autowired
    public UserController(UserDetailService userService) {
        this.userService = userService;
    }

//    @GetMapping("/users")
//    public Response<List<UserDetail>> getListOfUser(){
//        Response response = new Response<>();
//        response.setMessage("Success get user detail!");
//        response.setData(userService.getAllUserDetail());
//        return response;
//    }
        @GetMapping("/users")
        public List<UserDetail> getListOfUser(){
            return userService.getAllUserDetail();
        }

        @GetMapping("/users/{id}")
        public UserDetail getUserDetail(@PathVariable String id){
        return userService.getUserDetail(id);
        }

        @PutMapping("/users")
        public UserDetail updateUserDetail(@RequestBody UserDetail userDetail){
        return userService.update(userDetail);
        }

        @DeleteMapping("/users/{id}")
        public void deleteUser(@PathVariable String id){
         userService.deleteUser(id);
        }

}
