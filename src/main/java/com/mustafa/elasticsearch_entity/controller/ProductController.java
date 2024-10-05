package com.mustafa.elasticsearch_entity.controller;

import com.mustafa.elasticsearch_entity.dto.ProductDTO;
import com.mustafa.elasticsearch_entity.entity.Product;
import com.mustafa.elasticsearch_entity.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        return productService.create(product);
    }

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productService.searchAll();
    }

    @GetMapping("/search")
    @ApiOperation("Şuan price değeri için order çalışıyor. Text değerleri ve id'yi order da sağlanılmadı henüz")
    public Page<Product> searchByName(@RequestParam String name,
                                      @RequestParam(defaultValue = "0") Integer page,
                                      @RequestParam(defaultValue = "10") Integer perPage,
                                      @RequestParam(defaultValue = "price") String sortBy,
                                      @RequestParam(defaultValue = "false") Boolean desc) {
        Sort sort = desc ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, perPage, sort);
        return productService.searchByName(name, pageable);
    }

    @GetMapping("/search-by-containing")
    @ApiOperation("Şuan price değeri için order çalışıyor. Text değerleri ve id'yi order da sağlanılmadı henüz")
    public Page<Product> searchByContaining(@RequestParam String name,
                                            @RequestParam(defaultValue = "0") Integer page,
                                            @RequestParam(defaultValue = "10") Integer perPage,
                                            @RequestParam(defaultValue = "price") String sortBy,
                                            @RequestParam(defaultValue = "false") Boolean desc) {
        Sort sort = desc ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, perPage, sort);
        return productService.searchByNameContainingIgnoreCase(name, pageable);
    }

    @GetMapping("/search-by-price")
    @ApiOperation("Şuan price değeri için order çalışıyor. Text değerleri ve id'yi order da sağlanılmadı henüz")
    public Page<Product> searchByPriceRange(@RequestParam Double lower,
                                            @RequestParam Double upper,
                                            @RequestParam(defaultValue = "0") Integer page,
                                            @RequestParam(defaultValue = "10") Integer perPage,
                                            @RequestParam(defaultValue = "price") String sortBy,
                                            @RequestParam(defaultValue = "false") Boolean desc) {
        Sort sort = desc ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, perPage, sort);
        return productService.searchByPriceBetween(lower, upper, pageable);
    }

}
