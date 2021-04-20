package com.example.hakimlivs.model;

import HelpClasses.PriceMath;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by rakib
 * Date: 2021-04-12
 * Projekt: hakimlivs
 */
@Entity
@Table(name = "HAKIM_PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String title;
    @Column(name="Description", length=1500, nullable=false)
    protected String description;
    protected int stockInHand;
    protected String image;
    protected double price;
    protected double productprice;
    protected String category;
    @CreationTimestamp
    protected LocalDate dateadded;
    @UpdateTimestamp
    protected LocalDate dateedited;
    protected double weight;

    public Product() {
    }

    public Product(String title, String description, int stockInHand, String image, double price, double productprice, String category, LocalDate dateadded, LocalDate dateedited, double weight) {
        this.title = title;
        this.description = description;
        this.stockInHand = stockInHand;
        this.image = image;
        this.price = price;
        this.productprice = productprice;
        this.category = category;
        this.dateadded = dateadded;
        this.dateedited = dateedited;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public double getPricecomparison() {
        Double priceComp = (price / weight) * 1000.0;
        return PriceMath.round(priceComp,2);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getStockInHand() {
        return stockInHand;
    }

    public void setStockInHand(int stockInHand) {
        this.stockInHand = stockInHand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", productprice=" + productprice +
                ", category='" + category + '\'' +
                ", dateadded=" + dateadded +
                ", dateedited=" + dateedited +
                ", pricecomparison=" + this.getPricecomparison() +
                ", weight=" + weight +
                '}';
    }
}
