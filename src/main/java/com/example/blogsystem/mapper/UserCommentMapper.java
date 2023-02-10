package com.example.blogsystem.mapper;

import com.example.blogsystem.dto.UserDTO;
import com.example.blogsystem.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CommentMapper.class,BlogMapper.class,AddressMapper.class})
public interface UserCommentMapper {
    @Mapping(target = "email",ignore = true)
    @Mapping(target = "password",ignore = true)
    @Mapping(source = "address",target = "address",ignore = true)
    @Mapping(source = "blog",target = "blogs",ignore = true)
    UserDTO userDTO(User user);

    @Mapping(target = "email",ignore = true)
    @Mapping(target = "password",ignore = true)
    @Mapping(source = "address", target = "address",ignore = true)
    @Mapping(source = "blogs", target = "blog",ignore = true)
    User dtoUser(UserDTO userDTO);

    List<UserDTO> userDTOList(List<User> userDTOList);
}
