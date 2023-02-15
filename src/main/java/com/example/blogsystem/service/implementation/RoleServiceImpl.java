package com.example.blogsystem.service.implementation;

import com.example.blogsystem.dto.RoleDTO;
import com.example.blogsystem.entity.Role;
import com.example.blogsystem.mapper.RoleMapper;
import com.example.blogsystem.repository.RoleRepository;
import com.example.blogsystem.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDTO saveRole(Role role) {
        Role save=roleRepository.save(role);
        RoleDTO roleDTO=roleMapper.roleDTO(save);
        return roleDTO;
    }

    @Override
    public List<RoleDTO> fetchAllRole() {
        List<Role> fetchAll= roleRepository.findAll();
        List<RoleDTO>fetch=roleMapper.roleDTOList(fetchAll);
        return fetch;

    }
}
