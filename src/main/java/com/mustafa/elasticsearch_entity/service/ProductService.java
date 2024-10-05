package com.mustafa.elasticsearch_entity.service;

import com.mustafa.elasticsearch_entity.entity.Product;
import com.mustafa.elasticsearch_entity.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Iterable<Product> searchAll() {
        return productRepository.findAll();
    }

    public Page<Product> searchByName(String name, Pageable pageable) {
        return productRepository.findByName(name, pageable);
    }

    public Page<Product> searchByNameContainingIgnoreCase(String name, Pageable pageable) {
        return productRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public Page<Product> searchByPriceBetween(Double lower, Double higher, Pageable pageable) {
        return productRepository.findByPriceBetween(lower, higher, pageable);
    }
}
