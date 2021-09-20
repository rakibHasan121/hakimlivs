package com.example.hakimlivs.persistance;

import com.example.hakimlivs.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rakib
 * Date: 2021-04-12
 * Projekt: hakimlivs
 */
@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
    Product findByTitle(String title);
    Product getProductById(Long id);
}