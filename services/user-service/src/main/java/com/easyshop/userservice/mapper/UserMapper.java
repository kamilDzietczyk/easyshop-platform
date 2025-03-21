package com.easyshop.userservice.mapper;

import com.easyshop.userservice.dto.UserRegistrationDTO;
import com.easyshop.userservice.dto.UserResponseDTO;
import com.easyshop.userservice.dto.UserUpdateDTO;
import com.easyshop.userservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
  UserResponseDTO userToUserResponseDTO(User user);
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "password", ignore = true)
  User userRegistrationDTOToUser(UserRegistrationDTO dto);
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "role", ignore = true)
  @Mapping(target = "password", ignore = true)
  void updateUserFromDTO(UserUpdateDTO dto, @MappingTarget User user);

}
