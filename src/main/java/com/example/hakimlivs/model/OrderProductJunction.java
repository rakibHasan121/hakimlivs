package com.example.hakimlivs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * OrderProductJunction is the relation between OrderEntity and Product classes.
 * It stores the order, the product amd the quantity of the product ordered.
 *
 */
@Entity
public class OrderProductJunction {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="orderid")
    @JsonBackReference
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name="productid")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    public OrderProductJunction(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
