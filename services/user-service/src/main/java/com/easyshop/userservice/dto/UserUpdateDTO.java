package com.easyshop.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdateDTO {

  @NotBlank(message = "Name cannot be empty")
  private String name;

  @NotBlank(message = "Surname cannot be empty")
  private String surname;

  @Email(message = "Incorrect email format")
  private String email;

  private AddressDTO address;
  private AddressDTO deliveryAddress;
}
