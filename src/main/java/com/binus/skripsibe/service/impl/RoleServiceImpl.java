package com.binus.skripsibe.service.impl;

import com.binus.skripsibe.dto.ERole;
import com.binus.skripsibe.entity.Role;
import com.binus.skripsibe.repository.RoleRepository;
import com.binus.skripsibe.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role getOrSave(ERole role) {
        return roleRepository.findByRole(role)
                .orElseGet(() -> roleRepository.save(new Role(null, role)));
    }
}
