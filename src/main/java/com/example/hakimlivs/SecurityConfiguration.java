package com.example.hakimlivs;

import com.example.hakimlivs.repository.CustomerRepository;
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
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTIssuer jwtIssuer;

    @Autowired
    public SecurityConfiguration(UserRepository userRepo, CustomerRepository customerRepository, PasswordEncoder passwordEncoder, JWTIssuer jwtIssuer) {
        this.userRepo = userRepo;
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtIssuer = jwtIssuer;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final JWTAuthenticationFilter filter = new JWTAuthenticationFilter(authenticationManager(), jwtIssuer, new ObjectMapper());
        final JWTAuthorizationFilter jwtAuthorizationFilter = new JWTAuthorizationFilter(authenticationManager(), jwtIssuer);

  /*
        http
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
                    .antMatchers("/checkout/**").hasAuthority("CUSTOMER")
                    .antMatchers("/").anonymous()
                .and()
                .formLogin()
                    .loginPage("/")
                    .failureUrl("/?error")
                .and()
                .logout()
                    .logoutSuccessUrl("/");


        http
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
                .antMatchers("/checkout/*").hasRole("CUSTOMER")
                .antMatchers("/customer/details").hasRole("CUSTOMER")
                .antMatchers("/*","/resources/*","/templates/*","/static/*","/js/*","/css/*","/images/*", "/data/*" ).permitAll()
                .antMatchers("/customer/*").permitAll()
                .antMatchers("/api/*", "/data/*").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/")
                    .usernameParameter("email").permitAll()
                    .defaultSuccessUrl("/?success")
                    //.failureUrl("/?error")
                .and()
                    .addFilter(filter)
                    .addFilter(jwtAuthorizationFilter)
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
 */

        http
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
                .antMatchers("/checkout").hasAuthority("ROLE_CUSTOMER")
                .antMatchers("/orderbekraftelse.html").hasAuthority("ROLE_CUSTOMER")
                .antMatchers("/order/**").hasAuthority("ROLE_CUSTOMER")
                .antMatchers("/customer/details").hasAuthority("ROLE_CUSTOMER")
                .antMatchers("/*","/resources/*","/templates/*","/static/*","/js/*","/css/*","/images/*", "/data/*" ).permitAll()
                .antMatchers("/customer/*").permitAll()
                .antMatchers("/api/*", "/data/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/")
                .usernameParameter("email").permitAll()
                .defaultSuccessUrl("/?success")
                .failureUrl("/?error")
                .and()
                .logout().logoutUrl("/perform_logout")
                .logoutSuccessUrl("/?logged_out")
                .deleteCookies("JSESSIONID")
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerRepository::findCustomerByEmail).passwordEncoder(passwordEncoder);
    }



}