package com.example.hakimlivs.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderProductJunction> orderedProducts = new ArrayList<>();

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

    public List<OrderProductJunction> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderProductJunction> orderInProductOrderList) {
        this.orderedProducts = orderInProductOrderList;
    }

    public void addToOrderEntityInOrderProductJunctionList(OrderProductJunction junction){
        this.orderedProducts.add(junction);
    }

    public void removeOrderEntityInOrderProductJunctionList(OrderProductJunction junction){
        this.orderedProducts.remove(junction);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", customer=" + customer +
                '}';
    }

}
