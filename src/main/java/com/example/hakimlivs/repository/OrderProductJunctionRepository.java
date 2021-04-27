package com.example.hakimlivs.repository;

import com.example.hakimlivs.model.OrderEntity;
import com.example.hakimlivs.model.OrderProductJunction;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductJunctionRepository extends CrudRepository<OrderProductJunction, Long> {

    OrderProductJunction findOrderProductJunctionByOrderEntityIdAndProductId(Long orderid, Long productid);
}
