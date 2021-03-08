package com.saurabh.aop.services;

import com.saurabh.aop.models.Product;
import com.saurabh.aop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void initDB() {
        repository.saveAll(Stream.of(
                new Product("Book", 499),
                new Product("laptop", 78000)
        ).collect(Collectors.toList()));
    }

    public List<Product> addProduct(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> findAllProducts() {
        return repository.findAll();
    }
}
