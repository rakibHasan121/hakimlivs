package com.example.hakimlivs.presentation;

import com.example.hakimlivs.domain.Customer;
import com.example.hakimlivs.application.CustomerService;
import com.example.hakimlivs.presentation.dtos.UserDto;
import com.example.hakimlivs.persistance.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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



    //private final String MAILSERVER

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

    //TODO: Lägg till validering för ifall email redan finns.
    //Plockar upp alla emails, används av en javascript metod för att kolla emails.
/*    @GetMapping("customer/allemails")
    public @ResponseBody
    List<String> getAllCustomerEmails() {
        List<String> customerEmails = new ArrayList<>();

        for (Customer customer : customerRepo.findAll()) {
            customerEmails.add(customer.getEmail());
        }
        return customerEmails;
    }*/

    /*
    @PostMapping("login")
    public @ResponseBody login ()

     */

    @GetMapping("customer/details")
    public @ResponseBody Customer viewCustomerDetails (@AuthenticationPrincipal Customer customer) {
        System.out.println("customer details: " + customer.getEmail());
        return customerRepo.findCustomerByEmail(customer.getEmail());
    }

    @GetMapping("/checkout")
    public String customerCheckout (@AuthenticationPrincipal Customer customer, Model model) {
        System.out.println("customern som gick till checkout: " + customer.getEmail());
        /*model.addAttribute("productlist", new ProductOrderListDto());*/
        model.addAttribute("thcustomerid",customer.getId());

        return "checkout";
    }
}
