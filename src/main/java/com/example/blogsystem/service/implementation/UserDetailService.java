package com.example.blogsystem.service.implementation;

import com.example.blogsystem.config.UserUserDetails;
import com.example.blogsystem.entity.User;
import com.example.blogsystem.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailService implements UserDetailsService {

 private final UserRepository userRepository;


    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>user = userRepository.findByUsername(username);
        //user.get().getRole();
        return user.map(UserUserDetails::new).orElseThrow(()->new UsernameNotFoundException("Invalid User"+username));
    }
}
