package com.easyshop.userservice.service;

import com.easyshop.userservice.dto.UserRegistrationDTO;
import com.easyshop.userservice.dto.UserUpdateDTO;
import com.easyshop.userservice.mapper.UserMapper;
import com.easyshop.userservice.model.User;
import com.easyshop.userservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserMapper userMapper;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.userMapper = userMapper;
  }

  public User registerUser(UserRegistrationDTO dto) {
    User user = userMapper.userRegistrationDTOToUser(dto);
    user.setPassword(passwordEncoder.encode(dto.getPassword()));
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public User updateUser(Long id, UserUpdateDTO dto) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User not found"));

    userMapper.updateUserFromDTO(dto, user);

    return userRepository.save(user);
  }

  public void deleteUser(Long id) {
    if (!userRepository.existsById(id)) {
      throw new EntityNotFoundException("User not found");
    }
    userRepository.deleteById(id);
  }
}
