package com.easyshop.userservice.controller;

import com.easyshop.userservice.model.User;
import com.easyshop.userservice.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<User> registerUser(@RequestBody User user) {
    /*User savedUser = userService.saveUser(user);
    return ResponseEntity.ok(savedUser);*/
    int value;
    /*value = user.getEmail().length();*/
    System.out.println("Otrzymano żądanie rejestracji: ");
    User savedUser = userService.saveUser(user);
    return ResponseEntity.ok(savedUser);
  }

  @GetMapping("/{email}")
  public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
    Optional<User> user = userService.findByEmail(email);
    return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
