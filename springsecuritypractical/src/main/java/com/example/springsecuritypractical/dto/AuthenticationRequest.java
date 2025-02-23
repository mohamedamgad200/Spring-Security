package com.example.springsecuritypractical.dto;

import com.example.springsecuritypractical.entity.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
