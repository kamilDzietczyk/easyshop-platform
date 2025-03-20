package com.easyshop.userservice.service;

import com.easyshop.userservice.model.User;
import com.easyshop.userservice.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }
}
