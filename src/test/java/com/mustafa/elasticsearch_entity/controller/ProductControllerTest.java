package com.mustafa.elasticsearch_entity.controller;

import com.mustafa.elasticsearch_entity.entity.Product;
import com.mustafa.elasticsearch_entity.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductControllerTest {

   /* @Autowired
    private ProductRepository productRepository;

    @Test
    public void testProductRepository() {
        Product product = new Product();
        product.setId("1");
        product.setName("Test Product");
        product.setDescription("This is a test product.");
        product.setPrice(10.0);

        productRepository.save(product);
        assertNotNull(productRepository.findById("1"));
    }*/
}
