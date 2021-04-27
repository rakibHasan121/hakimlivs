package com.example.hakimlivs.controller;

import com.example.hakimlivs.model.Customer;
import com.example.hakimlivs.model.OrderEntity;
import com.example.hakimlivs.model.OrderProductJunction;
import com.example.hakimlivs.model.Product;
import com.example.hakimlivs.repository.CustomerRepository;
import com.example.hakimlivs.repository.OrderEntityRepository;
import com.example.hakimlivs.repository.OrderProductJunctionRepository;
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
@CrossOrigin
@RequestMapping("/order")
public class OrderEntityController {

    @Autowired
    OrderEntityRepository OERepo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    ProductsRepository productsRepo;

    @Autowired
    OrderProductJunctionRepository orderProductJunction;

    @GetMapping(path="/all")
    public Iterable <OrderEntity> getAllOrders(){
        return OERepo.findAll();
    }

    @RequestMapping("/add")
    public OrderEntity createOrder(@RequestParam Long customerID ) {
        Customer selectedCustomer = customerRepo.getCustomerById(customerID);
        OrderEntity createdOrder = new OrderEntity();
        createdOrder.setCustomer(selectedCustomer);
        return OERepo.save(createdOrder);
    }

    @RequestMapping("/addproducts")
    public OrderEntity createOrder(@RequestParam Long orderID, @RequestParam Long productID ) {

        OrderEntity currentOrder = OERepo.getOrderEntityById(orderID);
        Product currentProduct = productsRepo.getProductById(productID);

        currentOrder.addProduct(currentProduct);

        OrderProductJunction junctionTable = orderProductJunction.findOrderProductJunctionByOrderEntityIdAndProductId(orderID,productID);


        return OERepo.save(currentOrder);
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
