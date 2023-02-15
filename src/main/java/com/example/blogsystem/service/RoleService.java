package com.example.blogsystem.service;

import com.example.blogsystem.dto.RoleDTO;
import com.example.blogsystem.entity.Role;

import java.util.List;

public interface RoleService {
    RoleDTO saveRole(Role role);


    List<RoleDTO> fetchAllRole();
}
