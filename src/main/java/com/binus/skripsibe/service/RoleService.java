package com.binus.skripsibe.service;

import com.binus.skripsibe.dto.ERole;
import com.binus.skripsibe.entity.Role;

public interface RoleService {
    Role getOrSave(ERole role);
}
