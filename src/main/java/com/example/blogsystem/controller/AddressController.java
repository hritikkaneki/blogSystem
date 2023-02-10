package com.example.blogsystem.controller;

import com.example.blogsystem.dto.AddressDTO;
import com.example.blogsystem.entity.Address;
import com.example.blogsystem.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/saveAddress")
    public ResponseEntity<?>saveAddress(@RequestBody Address address){

        return new ResponseEntity<>(addressService.saveAddress(address), HttpStatus.CREATED);
    }

    @GetMapping("/getAddress")
    public ResponseEntity<?>address(){
        return new ResponseEntity<>(addressService.fetchAllAddress(),HttpStatus.OK);
    }
}
