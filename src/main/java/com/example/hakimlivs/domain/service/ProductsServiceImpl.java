package com.example.hakimlivs.domain.service;

import com.example.hakimlivs.domain.Product;
import com.example.hakimlivs.persistance.CustomerRepository;
import com.example.hakimlivs.persistance.OrderEntityRepository;
import com.example.hakimlivs.persistance.OrderProductJunctionRepository;
import com.example.hakimlivs.persistance.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rakib
 * Date: 2021-04-12
 * Projekt: hakimlivs
 */
@Service
public class ProductsServiceImpl implements ProductService {
    private final ProductsRepository productsRepository;


    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Autowired
    private OrderProductJunctionRepository orderProductJunctionRepository;
    @Autowired
    private CustomerRepository customerRepo;
    @Autowired
    private OrderEntityRepository orderEntityRepository;

    /*GET Method*/
    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Product getProductByID(int id) {
        return productsRepository.findById((long)id).orElse(null);
    }

    @Override
    public Product getProductByName(String name) {
        return productsRepository.findByTitle(name);
    }

    /*POST Method*/
    @Override
    public Product saveProduct(Product product) {
        return productsRepository.save(product);
    }

    @Override
    public List<Product> saveProducts(List<Product> products) {
        return productsRepository.saveAll(products);
    }

    /*DELETE Method*/
    @Override
    public String deleteProduct(int id) {

        productsRepository.deleteById((long) id);
        return "Product Deleted!!";
    }

    /*UPDATE Method*/
    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = productsRepository.findById(product.getId()).orElse(null);
        existingProduct.setTitle(product.getTitle());
        existingProduct.setProductprice(product.getProductprice());
        existingProduct.setWeight(product.getWeight());
        return productsRepository.save(existingProduct);
    }

    /*DELETE all products Method*/
    @Override
    public String deleteAllProducts() {
        orderProductJunctionRepository.deleteAll();
        orderEntityRepository.deleteAll();
        customerRepo.deleteAll();
        productsRepository.deleteAll();
        return "All products have been deleted successfully";
    }


}