package com.example.blogsystem.controller;

import com.example.blogsystem.dto.UserDTO;
import com.example.blogsystem.entity.User;
import com.example.blogsystem.exception.CustomException;
import com.example.blogsystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<?>save(@RequestBody User user){
        System.out.println(user);
       // return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getUser")
    public ResponseEntity<?>fetchAllUsers(){
        return new ResponseEntity<>(userService.fetchAllUsers(),HttpStatus.OK);
    }

    @DeleteMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id")Long id)throws CustomException {
        userService.deleteUser(id);
        return "Successfully Deleted User with Id:"+id;
    }

    @PatchMapping("/updateUser/{id}")
    public ResponseEntity<?>updateUser(@RequestBody User user,@PathVariable("id")Long id) throws CustomException {
        return  new ResponseEntity<>(userService.updateUser(user,id),HttpStatus.OK);
    }



}
