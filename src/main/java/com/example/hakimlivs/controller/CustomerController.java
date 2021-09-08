package com.example.hakimlivs.controller;
import com.example.hakimlivs.application.CustomerService;
import com.example.hakimlivs.model.Customer;
import com.example.hakimlivs.model.Role;
import com.example.hakimlivs.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Handles requests related to the customer class
 */

@Controller
@CrossOrigin
@RequestMapping(path="/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public String saveCustomer(Customer customer) {
        customerService.signUp(customer);
        return "redirect:/";
    }
}
