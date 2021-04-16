package com.example.hakimlivs.controller;

import com.example.hakimlivs.model.Product;
import com.example.hakimlivs.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rakib
 * Date: 2021-04-12
 * Projekt: hakimlivs
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addproduct")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addproducts")
    public List<Product> saveProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product findByProductByID(@PathVariable int id) {
        return productService.getProductByID(id);
    }

    @GetMapping("/product/{titel}")
    public Product findByProductByName(@PathVariable String titel) {
        return productService.getProductByName(titel);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    @DeleteMapping("/deleteall")
    public String deleteAllProducts(@RequestBody List<Product> products) {
        return productService.deleteAllProducts(products);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}