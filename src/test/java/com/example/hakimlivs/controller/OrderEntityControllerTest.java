package com.example.hakimlivs.controller;

import com.example.hakimlivs.model.Customer;
import com.example.hakimlivs.model.OrderProductJunction;
import com.example.hakimlivs.model.Product;
import com.example.hakimlivs.repository.CustomerRepository;
import com.example.hakimlivs.repository.OrderEntityRepository;
import com.example.hakimlivs.repository.ProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class OrderEntityControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    CustomerRepository mockCustomerRepo;

    @MockBean
    OrderEntityRepository mockOrderEntityRepo;

    @MockBean
    OrderProductJunction mockOrderProductJunctionRepo;

    @MockBean
    ProductsRepository mockProductRepo;

    @BeforeEach
    public void init(){

        //Mock customers
        Customer customer1 = new Customer();
        customer1.setFirstname("testname");
        customer1.setLastname("testlastname");
        customer1.setAddress("testaddress");
        customer1.setCity("testcity");
        customer1.setEmail("testmail@testhost.com");
        customer1.setPhone("070-1234567");
        customer1.setZipcode("123 45");

        Customer customer2 = new Customer();
        customer2.setFirstname("testname2");
        customer2.setLastname("testlastname2");
        customer2.setAddress("testaddress2");
        customer2.setCity("testcity2");
        customer2.setEmail("testmail2@testhost2.com");
        customer2.setPhone("072-2234567");
        customer2.setZipcode("223 42");

        //Mock products
        Product product1 = new Product();
        product1.setTitle("testprod1");
        product1.setPrice(100);
        product1.setProductprice(50);
        product1.setWeight(100);
        product1.setCategory("testcategory");
        product1.setDescription("testdescription");
        product1.setStockInHand(10);
        product1.setImage("image.jpg");

        Product product2 = new Product();
        product2.setTitle("testprod2");
        product2.setPrice(10);
        product2.setProductprice(5);
        product2.setWeight(10);
        product2.setCategory("testcategory2");
        product2.setDescription("testdescription2");
        product2.setStockInHand(5);
        product2.setImage("image2.jpg");


        when(mockCustomerRepo.getCustomerById(1L)).thenReturn(customer1);
        when(mockCustomerRepo.getCustomerById(2L)).thenReturn(customer2);

        when(mockProductRepo.getProductById(1L)).thenReturn(product1);
        when(mockProductRepo.getProductById(2L)).thenReturn(product2);


    }

    @Test
    public void addOrderTest() throws Exception {

        /*
        mvc.perform(MockMvcRequestBuilders.get("/order/add?customerID=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("""{
                        name
                        }"""

                        ));

         */
    }

}
