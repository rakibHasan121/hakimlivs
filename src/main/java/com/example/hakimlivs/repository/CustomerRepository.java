package com.example.hakimlivs.repository;

import com.example.hakimlivs.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by: Ulf Nyberg
 * Date: 2021-04-21
 * Time: 09:22
 * Project: hakimlivsRakib
 * Copyright: MIT
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
