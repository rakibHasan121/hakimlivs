package com.example.hakimlivs.service;

import com.example.hakimlivs.model.Customer;
import com.example.hakimlivs.model.Role;
import com.example.hakimlivs.repository.CustomerRepository;
import com.example.hakimlivs.security.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailConnectionService mailConnectionService;

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

        Customer savedCustomer = customerRepository.save(newCustomer);

        if(savedCustomer != null){
            try {
                mailConnectionService.sendMailNewCustomer(savedCustomer.getEmail());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return savedCustomer;
        }
        return null;
    }

    public boolean login(UserDto userDto) {
        if (!emailExists(userDto.getEmail())) {
            //TODO: Lägg till ordentlig felsökning
            return false;
        }
        Customer customer = customerRepository.findCustomerByEmail(userDto.getEmail());
        return passwordEncoder.matches(userDto.getPassword(), customer.getPassword());
    }

    private boolean emailExists(String email) {
        return customerRepository.findCustomerByEmail(email) != null;
    }
}
