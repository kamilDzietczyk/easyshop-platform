package com.easyshop.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable()) // Wyłączenie CSRF (na czas testów)
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/users/**").permitAll() // Zezwolenie na dostęp do wszystkich endpointów w "/users/"
            .anyRequest().permitAll() // Zezwolenie na WSZYSTKIE inne żądania (na razie)
        )
        .formLogin(form -> form.disable()) // Wyłączenie logowania przez formularz
        .httpBasic(basic -> basic.disable()); // Wyłączenie Basic Auth

    return http.build();
  }
}
