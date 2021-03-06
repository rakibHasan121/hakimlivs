package com.example.hakimlivs.presentation;

import com.example.hakimlivs.domain.Customer;
import com.example.hakimlivs.domain.OrderEntity;
import com.example.hakimlivs.domain.OrderProductJunction;
import com.example.hakimlivs.domain.Product;
import com.example.hakimlivs.persistance.CustomerRepository;
import com.example.hakimlivs.persistance.OrderEntityRepository;
import com.example.hakimlivs.persistance.OrderProductJunctionRepository;
import com.example.hakimlivs.persistance.ProductsRepository;
import com.example.hakimlivs.application.MailConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by: Ulf Nyberg
 * Date: 2021-04-21
 * Time: 09:23
 * Project: hakimlivsRakib
 * Copyright: MIT
 *
 * Handles requests related to the order class
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

    @Autowired
    private MailConnectionService mailConnectionService;

    /**
     * Returns all orders with get mapping
     * @return All orders in the database
     */
    @GetMapping(path="/all")
    public Iterable <OrderEntity> getAllOrders(){
        return OrderEntityRepository.findAll();
    }

    /**
     * Requestmapping to add orders
     *
     * @param customerID The id of the customer owning the order
     * @return the OrderEntity object created
     */
    @RequestMapping("/add")
    public OrderEntity createOrder(@RequestParam Long customerID ) {
        Customer selectedCustomer = customerRepo.getCustomerById(customerID);
        OrderEntity createdOrder = new OrderEntity();
        createdOrder.setCustomer(selectedCustomer);
        return OrderEntityRepository.save(createdOrder);
    }

    @RequestMapping("/complete")
    public void completeOrder(@RequestParam Long orderID ) {
        OrderEntity order = OrderEntityRepository.getOrderEntityById(orderID);
        if(order != null){
            try {
                mailConnectionService.sendMailNewOrder(order.getCustomer().getEmail(), orderID);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds a product to a specific order with a quantity if
     * the products is not already registered in the order
     *
     * @param orderID The id of the order
     * @param productID The id of the product to be added
     * @param productQuantity The number of the selected product to be added
     * @return
     */
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

    // @Postmapping
    //public String receiveOrder(@AuthenticationPrincipal Customer customer, @Requestparm-ish List<items> orderitems){
    //
    // OrderEntity order = new Order();
    //
    // foreach(orderitems:)
    //  productsrepo.findbyid(orderitems.id)
    //
    //
    // order.setCustomer(customerRepo.findcustomerbyemail(customer);
    // order.addProducts(orderitems)
    // OrderRepository.save(order);
    //return "finemangs!";
    //
    //
    //}

}
