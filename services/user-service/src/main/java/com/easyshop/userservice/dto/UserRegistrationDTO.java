package com.easyshop.userservice.dto;

import com.easyshop.userservice.enums.Role;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegistrationDTO {
  @Email(message = "Incorrect email format")
  @NotBlank(message = "Email is required")
  private String email;

  @NotBlank(message = "Name is required")
  private String name;

  @NotBlank(message = "Surname is required")
  private String surname;

  @NotBlank(message = "Password is required")
  @Size(min = 6, message = "The password must have a minimum of 6 characters")
  private String password;

  @NotNull(message = "Role is required")
  private Role role;

  private AddressDTO address;
  private AddressDTO deliveryAddress;
}
