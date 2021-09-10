package com.example.hakimlivs.controller;

import com.example.hakimlivs.model.Customer;
import com.example.hakimlivs.repository.CustomerRepository;
import com.example.hakimlivs.security.UserDto;
import com.example.hakimlivs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("/login")
    public String loginCustomer(UserDto userDto) {
        if (customerService.login(userDto)) {
            System.out.println("Lyckades med login");
        } else {
            System.out.println("Misslyckades med login");
        }
        return "redirect:/";
    }

    @GetMapping("/all")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerRepo.findAll());
        return "customers";
    }
}
