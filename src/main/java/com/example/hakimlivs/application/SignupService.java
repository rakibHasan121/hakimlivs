package com.example.hakimlivs.application;

import com.example.hakimlivs.model.Role;
import com.example.hakimlivs.model.User;
import com.example.hakimlivs.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
