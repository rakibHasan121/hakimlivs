package com.example.hakimlivs;

import com.example.hakimlivs.repository.UserRepository;
import com.example.hakimlivs.security.JWTAuthenticationFilter;
import com.example.hakimlivs.security.JWTAuthorizationFilter;
import com.example.hakimlivs.security.JWTIssuer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JWTIssuer jwtIssuer;

    @Autowired
    public SecurityConfiguration(UserRepository userRepo, PasswordEncoder passwordEncoder, JWTIssuer jwtIssuer) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtIssuer = jwtIssuer;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final JWTAuthenticationFilter filter = new JWTAuthenticationFilter(authenticationManager(), jwtIssuer, new ObjectMapper());
        final JWTAuthorizationFilter jwtAuthorizationFilter = new JWTAuthorizationFilter(authenticationManager(), jwtIssuer);

        http
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
                .antMatchers("/*","/resources/*","/templates/*","/static/*","/js/*","/css/*","/images/*").permitAll()
                .antMatchers("/customer/*").permitAll()
                .anyRequest().authenticated().and()
                .addFilter(filter)
                .addFilter(jwtAuthorizationFilter)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userRepo::findUserByUsername).passwordEncoder(passwordEncoder);
    }

}