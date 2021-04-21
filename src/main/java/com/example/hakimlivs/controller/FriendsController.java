package com.example.hakimlivs.controller;

/**
 * Created by: Ulf Nyberg
 * Date: 2021-04-21
 * Time: 09:03
 * Project: hakimlivsRakib
 * Copyright: MIT
 */

import com.example.hakimlivs.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FriendsController {

    @GetMapping("/friends")
    public String friendForm(Model model) {
        model.addAttribute("personForm", new Person());
        return "friendsForm";
    }

    @PostMapping("/friends")
    public String submissionResult(@ModelAttribute("personForm") Person person) {
        System.out.println(person);
        return "result";
    }

}
