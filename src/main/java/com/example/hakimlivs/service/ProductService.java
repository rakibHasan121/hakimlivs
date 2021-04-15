package com.example.hakimlivs.service;

import com.example.hakimlivs.model.Product;

import java.util.List;

/**
 * Created by rakib
 * Date: 2021-04-12
 * Projekt: hakimlivs
 */
public interface ProductService {
    List<Product> getAllProducts();

    Product getProductByID(int id);

    List<Product> saveProducts(List<Product> products);

    Product getProductByName(String title);

    Product saveProduct(Product product);

    String deleteProduct(int id);

    String deleteAllProducts(List<Product> products);

    Product updateProduct(Product product);
}
