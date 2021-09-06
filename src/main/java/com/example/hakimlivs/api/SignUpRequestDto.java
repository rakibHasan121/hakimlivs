package com.example.hakimlivs.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpRequestDto {
    private final String username;
    private final String password;
    private final List<String> roles;

    public SignUpRequestDto(String username, String password, List<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = List.copyOf(roles);
    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRoles() {
       return List.copyOf(roles);
    }
}
