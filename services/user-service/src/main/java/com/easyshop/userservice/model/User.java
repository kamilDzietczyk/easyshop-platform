package com.easyshop.userservice.model;

import com.easyshop.userservice.enums.Role;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String email;

  private String name;
  private String surname;

  @Column(nullable = false)
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  private String phoneNumber;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Address> addresses;

  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  private String createdAt;

  private String updatedAt;

  @Column(nullable = false)
  private boolean isActive = true;
}
