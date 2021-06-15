package com.codecool.spingboot_tasks.error_handling.controller;



import com.codecool.spingboot_tasks.error_handling.dto.ErrorDto;
import com.codecool.spingboot_tasks.error_handling.exception.ProductNotFoundException;
import com.codecool.spingboot_tasks.error_handling.service.Product;
import com.codecool.spingboot_tasks.error_handling.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public List<Product> getProducts(@PathVariable long id){
        return productService.getProduct(id);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ ProductNotFoundException.class })
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        System.out.println(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND.value())
                .body(new ErrorDto("test", e.getMessage()));
    }
}
