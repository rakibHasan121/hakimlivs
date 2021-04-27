package com.example.hakimlivs.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ordertable")
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn
    private Customer customer;

    @OneToMany (cascade = CascadeType.ALL)
    private List<OrderProductJunction> orderInProductOrderJunctionList = new ArrayList<>();

    @CreationTimestamp
    protected LocalDate dateadded;

    @UpdateTimestamp
    protected LocalDate dateedited;



    public OrderEntity() {
    }

    public LocalDate getDateadded() {
        return dateadded;
    }

    public void setDateadded(LocalDate dateadded) {
        this.dateadded = dateadded;
    }

    public LocalDate getDateedited() {
        return dateedited;
    }

    public void setDateedited(LocalDate dateedited) {
        this.dateedited = dateedited;
    }

    public List<OrderProductJunction> getOrderInProductOrderJunctionList() {
        return orderInProductOrderJunctionList;
    }

    public void setOrderInProductOrderJunctionList(List<OrderProductJunction> orderInProductOrderList) {
        this.orderInProductOrderJunctionList = orderInProductOrderList;
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
