package com.example.hakimlivs.service;

import com.example.hakimlivs.model.Customer;
import com.example.hakimlivs.model.Role;
import com.example.hakimlivs.repository.CustomerRepository;
import com.example.hakimlivs.security.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Customer signUp(Customer customer) {
        if (emailExists(customer.getEmail())){
            //TODO: Lägg till ordentlig felsökning
            return customer;
        }
        Customer newCustomer = new Customer();
        newCustomer.setFirstname(customer.getFirstname());
        newCustomer.setLastname(customer.getLastname());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setAddress(customer.getAddress());
        newCustomer.setZipcode(customer.getZipcode());
        newCustomer.setCity(customer.getCity());
        newCustomer.setPhone(customer.getPhone());

        newCustomer.setPassword(passwordEncoder.encode(customer.getPassword()));
        newCustomer.setRole(Role.CUSTOMER);
        return customerRepository.save(newCustomer);
    }

    public boolean login(UserDto userDto) {
        if (!emailExists(userDto.getUsername())) {
            //TODO: Lägg till ordentlig felsökning
            return false;
        }
        Customer customer = customerRepository.findCustomerByEmail(userDto.getUsername());
        return passwordEncoder.matches(userDto.getPassword(), customer.getPassword());
    }

    private boolean emailExists(String email) {
        return customerRepository.findCustomerByEmail(email) != null;
    }
}
