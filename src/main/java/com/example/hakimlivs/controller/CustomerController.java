package com.example.hakimlivs.controller;

import com.example.hakimlivs.model.Customer;
import com.example.hakimlivs.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Handles requests related to the customer class
 */

@RestController
@CrossOrigin
@RequestMapping(path="/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

    /**
     * Receives a customer object as input and saves it to the database
     * @param customer
     * @return
     */
    @PostMapping("/add")
    public Customer saveCustomer(@RequestBody Customer customer) {

        return customerRepo.save(customer);
    }
}
