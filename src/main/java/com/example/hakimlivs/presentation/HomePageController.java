package com.example.hakimlivs.presentation;

import com.example.hakimlivs.domain.Customer;
import com.example.hakimlivs.presentation.dtos.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by rakib
 * Date: 2021-09-01
 * Projekt: hakimlivs
 */
@Controller
@CrossOrigin
public class HomePageController {
    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("customer",new Customer());
        model.addAttribute("userdto", new UserDto());
        return "index";
    }
}