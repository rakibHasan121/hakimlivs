package com.example.hakimlivs.controller;

import com.example.hakimlivs.model.Customer;
import com.example.hakimlivs.model.ProductOrderListDto;
import com.example.hakimlivs.repository.CustomerRepository;
import com.example.hakimlivs.security.UserDto;
import com.example.hakimlivs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles requests related to the customer class
 */

@Controller
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private CustomerService customerService;

    @PostMapping("customer/add")
    public String saveCustomer(Customer customer) {
        customerService.signUp(customer);
        return "redirect:/";
    }

    @PostMapping("customer/login")
    public String loginCustomer(UserDto userDto) {
        if (customerService.login(userDto)) {
            System.out.println("Lyckades med login");
        } else {
            System.out.println("Misslyckades med login");
        }
        return "redirect:/";
    }

    @GetMapping("customer/all")
    public @ResponseBody
    Iterable<Customer> getAllCustomers(Model model) {
        model.addAttribute("customers", customerRepo.findAll());
        return customerRepo.findAll();
    }

    /*
    @PostMapping("login")
    public @ResponseBody login ()

     */

    @GetMapping("customer/details") public @ResponseBody Customer viewCustomerDetails (@AuthenticationPrincipal Customer customer) {
        System.out.println("customer details: " + customer.getEmail());
        return customerRepo.findCustomerByEmail(customer.getEmail());
    }

    @GetMapping("/checkout")
    public String customerCheckout (@AuthenticationPrincipal Customer customer, Model model) {
        System.out.println("customern som gick till checkout: " + customer.getEmail());
        model.addAttribute("productlist", new ProductOrderListDto());
        model.addAttribute("thcustomerid",customer.getId());

        return "checkout";
    }
}
