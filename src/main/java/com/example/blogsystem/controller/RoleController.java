package com.example.blogsystem.controller;

import com.example.blogsystem.entity.Role;
import com.example.blogsystem.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/addRole")
    public ResponseEntity<?> addRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.saveRole(role), HttpStatus.CREATED);
    }

    @GetMapping("/roles")
    public ResponseEntity<?>showRole(){
        return new ResponseEntity<>(roleService.fetchAllRole(),HttpStatus.OK);
    }
}
