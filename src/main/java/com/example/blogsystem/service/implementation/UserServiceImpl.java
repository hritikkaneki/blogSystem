package com.example.blogsystem.service.implementation;

import com.example.blogsystem.dto.UserDTO;
import com.example.blogsystem.entity.User;
import com.example.blogsystem.exception.CustomException;
import com.example.blogsystem.mapper.UserMapper;
import com.example.blogsystem.repository.UserRepository;
import com.example.blogsystem.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO saveUser(User user) {
//        User user= userMapper.dtoUser(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user);
        return userMapper.userDTO(save);
    }

    @Override
    public List<UserDTO> fetchAllUsers() {
        List<User> user = userRepository.findAll();
        //System.out.println(user);
        List<UserDTO>userDTOList=userMapper.userDTOList(user);
        return userDTOList;
    }

    @Override
    public void deleteUser(Long id) throws CustomException {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO updateUser(User user, Long id) throws CustomException {
        User updateUser = userRepository.findById(id).get();
        updateUser.setUserName(user.getUserName());
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());
        updateUser.setAddress(user.getAddress());

        UserDTO updateUserDTO= userMapper.userDTO(userRepository.save(updateUser));
        return updateUserDTO;
    }
}
