package com.example.hakimlivs.controller;

import com.example.hakimlivs.model.Customer;
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

        return "index";
    }
}