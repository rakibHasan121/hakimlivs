package com.example.hakimlivs.controller;

import com.example.hakimlivs.model.OrderEntity;
import com.example.hakimlivs.repository.CustomerRepository;
import com.example.hakimlivs.repository.OrderEntityRepository;
import com.example.hakimlivs.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by: Ulf Nyberg
 * Date: 2021-04-21
 * Time: 09:23
 * Project: hakimlivsRakib
 * Copyright: MIT
 */
@RestController
@RequestMapping("/order")
public class OrderEntityController {

    @Autowired
    OrderEntityRepository OERepo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    ProductsRepository productsRepo;

    @GetMapping(path="/all")
    public Iterable <OrderEntity> getAllOrders(){
        return OERepo.findAll();
    }

    /*
    @POSTMapping("/addOrder")
    public String greeting(@RequestParam String firstname,
                           @RequestParam String lastname, @RequestParam String address, @RequestParam String zipcode, Model model) {
        model.addAttribute(“fname", fname); model.addAttribute(“lname", lname);
        return "greeting.html";
    }

     */



}
