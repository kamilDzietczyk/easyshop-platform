package com.easyshop.userservice.mapper;

import com.easyshop.userservice.dto.AddressDTO;
import com.easyshop.userservice.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
  AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
  AddressDTO addressToAddressDTO(Address address);
  Address addressDTOToAddress(AddressDTO dto);
}
