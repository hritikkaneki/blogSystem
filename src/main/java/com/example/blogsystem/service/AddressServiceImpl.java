package com.example.blogsystem.service;

import com.example.blogsystem.dto.AddressDTO;
import com.example.blogsystem.entity.Address;
import com.example.blogsystem.mapper.AddressMapper;
import com.example.blogsystem.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressDTO saveAddress(Address address) {

        Address save = addressRepository.save(address);
       return addressMapper.addressDTO(save);

    }

    @Override
    public List<AddressDTO> fetchAllAddress() {
        List<Address>address=addressRepository.findAll();

        List<AddressDTO>addressDTOList = addressMapper.addressDTOList(address);
        return addressDTOList;
    }
}
