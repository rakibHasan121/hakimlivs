package com.example.hakimlivs.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Customer class represents a customer
 *
 */
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String firstname;
    private String lastname;
    private String address;
    private String zipcode;
    private String city;
    private String phone;
    private String password;


    @Enumerated(EnumType.STRING)
    private Role role;
    @CreationTimestamp
    protected LocalDate dateadded;

    @UpdateTimestamp
    protected LocalDate dateedited;


    public Customer(){

    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zip) {
        this.zipcode = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", adress='" + address + '\'' +
                ", zip='" + zipcode + '\'' +
                ", City='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
