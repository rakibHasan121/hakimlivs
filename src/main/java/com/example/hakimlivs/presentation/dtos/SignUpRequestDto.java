package com.example.hakimlivs.presentation.dtos;

import com.example.hakimlivs.domain.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpRequestDto {
    private final String email;
    private final String password;
    private final Role role;

    public SignUpRequestDto(String username, String password, Role role) {
        this.email = username;
        this.password = password;
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
       return role;
    }
}
