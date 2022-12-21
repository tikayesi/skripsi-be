package com.binus.skripsibe.service.impl;

import com.binus.skripsibe.dto.*;
import com.binus.skripsibe.entity.Role;
import com.binus.skripsibe.entity.User;
import com.binus.skripsibe.repository.UserRepository;
import com.binus.skripsibe.security.JwtUtils;
import com.binus.skripsibe.service.AuthService;
import com.binus.skripsibe.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository appUserRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final RoleService roleService;

    @Override
    public UserDTO register(AuthRequest user) {
        Role role = roleService.getOrSave(ERole.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = appUserRepository.save(new User(null, user.getUsername(), user.getPassword(), Collections.singletonList(role)));
        return new UserDTO(save);

    }

    @Override
    public LoginDTO login(AuthRequest user) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword())
        );
        System.out.println("LOGIN2: " + user.getUsername());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtUtils.generateTokenFromUsername(userDetails.getUsername());

        log.info("User : {} logged in at {}", user.getUsername(), new Date());

        return new LoginDTO(userDetails, token);

    }
}
