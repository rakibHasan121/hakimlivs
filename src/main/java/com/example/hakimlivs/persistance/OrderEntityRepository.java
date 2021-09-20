package com.example.hakimlivs.persistance;

import com.example.hakimlivs.domain.OrderEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by: Ulf Nyberg
 * Date: 2021-04-21
 * Time: 09:22
 * Project: hakimlivsRakib
 * Copyright: MIT
 *
 * OrderEntityRepository Interface contains extra methods for retrieving orders in the database.
 *
 */
public interface OrderEntityRepository extends CrudRepository <OrderEntity, Long> {

    OrderEntity getOrderEntityById(Long id);
}
