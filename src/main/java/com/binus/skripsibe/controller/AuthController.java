package com.binus.skripsibe.controller;

import com.binus.skripsibe.dto.AuthRequest;
import com.binus.skripsibe.dto.LoginDTO;
import com.binus.skripsibe.dto.UserDTO;
import com.binus.skripsibe.service.AuthService;
import com.binus.skripsibe.service.UserService;
import com.binus.skripsibe.utils.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        UserDTO register = authService.register(request);
//        userService.addUserDetail(request);

        Response<?> response = new Response<>(
                "Successfully create new user",
                register);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        System.out.println("LOGIN: "+ request);
        LoginDTO login = authService.login(request);

        Response<?> response = new Response<>(
                "Successfully login",
                login);

        return ResponseEntity.ok(response);
    }

}
