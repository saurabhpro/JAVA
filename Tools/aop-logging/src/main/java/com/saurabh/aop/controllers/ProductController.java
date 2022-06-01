package com.saurabh.aop.controllers;

import com.saurabh.aop.models.Product;
import com.saurabh.aop.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/products")
    public ResponseEntity<List<Product>> saveProducts(@RequestBody List<Product> products) {

        final List<Product> productList = service.addProduct(products);
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(service.findAllProducts());
    }
}
