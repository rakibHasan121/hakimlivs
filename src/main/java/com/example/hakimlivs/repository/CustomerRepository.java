package com.example.hakimlivs.repository;

import com.example.hakimlivs.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by: Ulf Nyberg
 * Date: 2021-04-21
 * Time: 09:22
 * Project: hakimlivsRakib
 * Copyright: MIT
 *
 * Customer repository interface contains extra methods for retrieving data
 * from the database.
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer getCustomerById(Long id);
    Customer findCustomerByEmail(String email);
}
