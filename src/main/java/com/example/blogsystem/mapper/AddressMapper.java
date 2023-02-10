package com.example.blogsystem.mapper;

import com.example.blogsystem.dto.AddressDTO;
import com.example.blogsystem.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO addressDTO(Address address);


    Address dtoAddress(AddressDTO addressDTO);
    List<AddressDTO> addressDTOList(List<Address> addressList);

}
