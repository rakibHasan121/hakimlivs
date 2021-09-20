package com.example.hakimlivs.domain.service;

import com.example.hakimlivs.domain.Role;
import com.example.hakimlivs.domain.User;
import com.example.hakimlivs.persistance.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignupService {
    public static final Logger LOG = LoggerFactory.getLogger(SignupService.class);

    private final UserRepository userRepository;

    public SignupService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(final String username, final String password, final Role role) {
        LOG.info("Signing up user {}", username);
        final User user = new User(username, password, role);
        userRepository.save(user);
    }
}
