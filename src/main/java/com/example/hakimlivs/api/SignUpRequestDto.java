package com.example.hakimlivs.api;

import com.example.hakimlivs.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpRequestDto {
    private final String username;
    private final String password;
    private final Role role;

    public SignUpRequestDto(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
       return role;
    }
}
