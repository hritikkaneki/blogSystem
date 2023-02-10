package com.example.blogsystem.service;

import com.example.blogsystem.dto.AddressDTO;
import com.example.blogsystem.entity.Address;

import java.util.List;

public interface AddressService {
AddressDTO saveAddress(Address address);
List<AddressDTO> fetchAllAddress();
}
