package com.example.hakimlivs.presentation;

import com.example.hakimlivs.application.SignupService;
import com.example.hakimlivs.presentation.dtos.SignUpRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserSignupController {
    private static final Logger LOG = LoggerFactory.getLogger(UserSignupController.class);
    private final SignupService signupService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserSignupController(final SignupService signupService, final PasswordEncoder passwordEncoder) {
        this.signupService = signupService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/user/signup")
    public void signUp(@RequestBody SignUpRequestDto signUpRequest) {
        LOG.info("Creating user {}", signUpRequest.getEmail());
        signupService.signUp(signUpRequest.getEmail(), passwordEncoder.encode(signUpRequest.getPassword()), signUpRequest.getRole());
    }

    /*
    TODO: Implementera rättigheter för kund och admin

    @GetMapping("/admin/hello")
    public String helloAdmin(@AuthenticationPrincipal User user) {
        return "hello, " + user.getUsername();
    }

    @GetMapping("/customer/hello")
    public String helloCustomer(@AuthenticationPrincipal User user) {
        return "hello, " + user.getUsername();
    }
     */
}
