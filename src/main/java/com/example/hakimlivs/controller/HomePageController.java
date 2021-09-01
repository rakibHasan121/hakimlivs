package com.example.hakimlivs.controller;

import org.springframework.stereotype.Controller;
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
    @GetMapping("/index.html")
    public String index() {
        return "index.html";
    }
}