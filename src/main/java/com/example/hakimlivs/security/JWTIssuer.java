package com.example.hakimlivs.security;

import com.example.hakimlivs.domain.Customer;
import com.example.hakimlivs.domain.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.GrantedAuthority;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class JWTIssuer {

    private final Key key;
    private final Duration validity;

    public JWTIssuer(final Key key, final Duration validity) {
        this.key = key;
        this.validity = validity;
    }

    public String generateToken(final Customer customer) {

        final String authorities = customer.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(customer.getUsername())
                .claim("authorities", authorities)
                .signWith(key)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(validity)))
                .compact();
    }

    public Customer validate(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

        String authorities = (String) claims.get("authorities");
        List<Role> roles = Arrays.stream(authorities.split(",")).map(r -> r.substring(5)).map(Role::valueOf).collect(Collectors.toList());
        return new Customer(claims.getSubject(), null, roles.get(0));
    }
}