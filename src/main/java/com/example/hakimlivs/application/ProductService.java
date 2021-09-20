package com.example.hakimlivs.application;

import com.example.hakimlivs.domain.Product;

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

    Product updateProduct(Product product);

    String deleteAllProducts();
}
