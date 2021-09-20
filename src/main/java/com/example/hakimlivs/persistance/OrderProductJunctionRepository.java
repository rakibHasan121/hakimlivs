package com.example.hakimlivs.persistance;

import com.example.hakimlivs.domain.OrderEntity;
import com.example.hakimlivs.domain.OrderProductJunction;
import com.example.hakimlivs.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * OrderProductJunctionRepository Interface contains methods to find orders
 * selected by order and productid, and by order and product classes.
 *
 */

public interface OrderProductJunctionRepository extends CrudRepository<OrderProductJunction, Long> {

    OrderProductJunction findOrderProductJunctionByOrderEntityIdAndProductId(Long orderid, Long productid);

    OrderProductJunction findOrderProductJunctionByOrderEntityAndProduct(OrderEntity order, Product product);
}
