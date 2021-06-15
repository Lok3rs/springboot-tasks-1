package com.codecool.spingboot_tasks.error_handling.service;

import com.codecool.spingboot_tasks.error_handling.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        String a = null;
        a.toString();
        return productRepository.findAll();
    }

    public List<Product> getProduct(long id) {
        return productRepository.findById(id);
    }
}
