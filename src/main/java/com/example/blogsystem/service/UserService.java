package com.example.blogsystem.service;

import com.example.blogsystem.dto.UserDTO;
import com.example.blogsystem.entity.User;
import com.example.blogsystem.exception.CustomException;

import java.util.List;

public interface UserService {
    UserDTO saveUser(User user);
    List<UserDTO> fetchAllUsers();

    void deleteUser(Long id) throws CustomException;

    UserDTO updateUser(User user, Long id) throws CustomException;
}
