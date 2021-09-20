package com.example.hakimlivs.config;

import com.example.hakimlivs.application.SignupService;
import com.example.hakimlivs.persistance.UserRepository;
import com.example.hakimlivs.security.JWTIssuer;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.spec.SecretKeySpec;
import java.time.Duration;

@Configuration
public class AppConfiguration {

    @Value("${security.signingKey}")
    private String signingKey;

    @Value("${security.algorithm}")
    private String algorithm;

    @Value("${security.validMinutes}")
    private Integer validMinutes;

    @Autowired
    private final UserRepository userRepository;

    public AppConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Bean
//    public UserRepository userRepository2(BCryptPasswordEncoder passwordEncoder) {
//        userRepository.save(new User("admin", passwordEncoder.encode("password"), Role.ADMIN));
//        return userRepository;
//    }

    @Bean
    public SignupService signupService(UserRepository userRepository) {
        return new SignupService(userRepository);
    }

    @Bean
    public JWTIssuer jwtIssuer() {
        final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.forName(algorithm);
        final byte[] signingKeyBytes = Base64.encodeBase64(signingKey.getBytes());
        return new JWTIssuer(new SecretKeySpec(signingKeyBytes, signatureAlgorithm.getJcaName()), Duration.ofMinutes(validMinutes));
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

/*
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver, SpringSecurityDialect sec) {
        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.addDialect(sec); // Enable use of "sec"
        return templateEngine;
    }


    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

*/
}
