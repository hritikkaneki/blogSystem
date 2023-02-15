package com.example.blogsystem.mapper;

import com.example.blogsystem.dto.UserDTO;
import com.example.blogsystem.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class,BlogMapper.class,CommentMapper.class})
public interface UserMapper {



   @Mapping(source = "address",target = "address")
   @Mapping(source = "blog",target = "blogs")
   @Mapping(source = "role",target = "role")
    UserDTO userDTO(User user);

    @Mapping(source = "address", target = "address")
    @Mapping(source = "blogs", target = "blog")
    @Mapping(source = "role", target = "role")
    User dtoUser(UserDTO userDTO);

    @Mapping(target = "email",ignore = true)
    @Mapping(target = "password",ignore = true)
    @Mapping(source = "address", target = "address",ignore = true)
    @Mapping(source = "blogs", target = "blog",ignore = true)
    @Named("UserComment")
    User dtoUserComment(UserDTO userDTO);


    List<UserDTO> userDTOList(List<User> userDTOList);





}
