package com.example.hakimlivs.model;

import org.hibernate.criterion.Order;

import javax.persistence.*;

@Entity
@Table(name="ordertable")
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne (cascade = CascadeType.ALL)
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

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", customer=" + customer +
                '}';
    }
}
