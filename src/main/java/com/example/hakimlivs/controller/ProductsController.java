package com.example.hakimlivs.controller;

import com.example.hakimlivs.model.Product;
import com.example.hakimlivs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rakib
 * Date: 2021-04-12
 * Projekt: hakimlivs
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductsController {
    @Autowired
    private ProductService productService;

    //Get all products
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.getAllProducts();
    }

    //Get a product by its id
    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return productService.getProductByID(id);
    }

    //Get a product by its title
    @GetMapping("/product/{titel}")
    public Product findProductByTitel(@PathVariable String titel) {
        return productService.getProductByName(titel);
    }

    //Add a product
    @PostMapping("/addproduct")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    //Add list of products
    @PostMapping("/addproducts")
    public List<Product> saveProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    //Delete a product
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    //Update a product
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}