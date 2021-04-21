package com.example.hakimlivs.model;

import org.hibernate.criterion.Order;

import javax.persistence.*;

@Entity
@Table(name="order")
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn
    private Customer customer;

    public OrderEntity(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
