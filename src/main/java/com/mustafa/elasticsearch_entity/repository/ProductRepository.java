package com.mustafa.elasticsearch_entity.repository;

import com.mustafa.elasticsearch_entity.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {
//    List<Product> findByName(String name);
    Page<Product> findByName(String name, Pageable pageable);
//    List<Product> findByNameContainingIgnoreCase(String name);
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Product> findByPriceBetween(Double lower, Double higher, Pageable pageable);
}
