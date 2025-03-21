package com.easyshop.userservice.controller;

import com.easyshop.userservice.dto.UserRegistrationDTO;
import com.easyshop.userservice.dto.UserResponseDTO;
import com.easyshop.userservice.dto.UserUpdateDTO;
import com.easyshop.userservice.mapper.UserMapper;
import com.easyshop.userservice.model.User;
import com.easyshop.userservice.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;
  private final UserMapper userMapper;

  public UserController(UserService userService, UserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;
  }
  @PostMapping("/register")
  public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRegistrationDTO dto) {
    User user = userService.registerUser(dto);
    return ResponseEntity.ok(userMapper.userToUserResponseDTO(user));
  }

  @GetMapping
  public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
    List<UserResponseDTO> users = userService.getAllUsers()
        .stream()
        .map(userMapper::userToUserResponseDTO)
        .collect(Collectors.toList());
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
    return userService.getUserById(id)
        .map(user -> ResponseEntity.ok(userMapper.userToUserResponseDTO(user)))
        .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO dto) {
    User updatedUser = userService.updateUser(id, dto);
    return ResponseEntity.ok(userMapper.userToUserResponseDTO(updatedUser));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }
}
