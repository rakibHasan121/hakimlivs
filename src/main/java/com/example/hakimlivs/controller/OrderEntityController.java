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
    OrderEntityRepository OrderEntityRepository;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    OrderProductJunctionRepository orderProductJunction;

    @GetMapping(path="/all")
    public Iterable <OrderEntity> getAllOrders(){
        return OrderEntityRepository.findAll();
    }

    @RequestMapping("/add")
    public OrderEntity createOrder(@RequestParam Long customerID ) {
        Customer selectedCustomer = customerRepo.getCustomerById(customerID);
        OrderEntity createdOrder = new OrderEntity();
        createdOrder.setCustomer(selectedCustomer);
        return OrderEntityRepository.save(createdOrder);
    }

    @RequestMapping("/addproducts")
    public String createOrder(@RequestParam Long orderID, @RequestParam Long productID, @RequestParam int productQuantity ) {

        OrderEntity currentOrder = OrderEntityRepository.getOrderEntityById(orderID);
        Product currentProduct = productsRepository.getProductById(productID);

        if(currentOrder != null && currentProduct != null) {
        OrderProductJunction junctionTable = orderProductJunction.findOrderProductJunctionByOrderEntityAndProduct(currentOrder, currentProduct);
            if (junctionTable == null) {

                junctionTable = new OrderProductJunction();
                junctionTable.setOrderEntity(currentOrder);
                junctionTable.setProduct(currentProduct);
                junctionTable.setQuantity(productQuantity);

                currentOrder.addToOrderEntityInOrderProductJunctionList(junctionTable);
                OrderEntityRepository.save(currentOrder);

                return String.format("added produkt %d to order %d with quantity %d",
                        productID,
                        orderID,
                        productQuantity);

            }
        }
        return "error processing request addproducts; orderid:" + orderID + " productid:" + productID;
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
