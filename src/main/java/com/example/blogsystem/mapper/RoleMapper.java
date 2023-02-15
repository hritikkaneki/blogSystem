package com.example.blogsystem.mapper;

import com.example.blogsystem.dto.RoleDTO;
import com.example.blogsystem.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO roleDTO(Role role);

    Role role(RoleDTO roleDTO);

    List<RoleDTO> roleDTOList(List<Role> role);
}
