package com.example.hakimlivs.presentation;

import com.example.hakimlivs.domain.Product;
import com.example.hakimlivs.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rakib
 * Date: 2021-04-12
 * Projekt: hakimlivs
 *
 * Class that handles request to add remove and edit products
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductsController {
    @Autowired
    private ProductService productService;

    /**
     * Default get request returns a simple string to check if backend is online
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "API is up and running";
    }

    /**
     * Returns all products stored in the database
     *
      * @return
     */
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Returns the product with the specified ID
     *
      * @param id ID of the selected product
     * @return
     */
    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return productService.getProductByID(id);
    }

    /**
     * Finds a product based on title
      * @param titel Title of the wanted product
     * @return the first product with the correct title
     */
    @GetMapping("/product/{titel}")
    public Product findProductByTitel(@PathVariable String titel) {
        return productService.getProductByName(titel);
    }

    /**
     * Post mapping that receives a product and saves it to the database.
     *
      * @param product
     * @return JSON with complete information of the added product
     */
    @PostMapping("/addproduct")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    /**
     * Receivs a list of products and adds them to the databse.
     *
      * @param products a list of products
     * @return the complete list of the added products
     */
    @PostMapping("/addproducts")
    public List<Product> saveProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    /**
     * Deletes the product with the ID
     * @param id id of the product to be deleted
     * @return the deleted product
     */
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    /**
     * updating a product. If the product does not exist it
     * creates it.
     *
      * @param product the updated product
     * @return the updated/created product is returned
     */
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    /**
     * Delete all products from the server
     * @return
     */
    @DeleteMapping("/deleteallproducts")
    public String deleteAllProducts() {
        return productService.deleteAllProducts();
    }
}