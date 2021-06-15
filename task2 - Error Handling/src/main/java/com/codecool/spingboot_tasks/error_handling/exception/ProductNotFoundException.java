package com.codecool.spingboot_tasks.error_handling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductNotFoundException extends RuntimeException {

    private String errorMsg;

    public ProductNotFoundException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }
}
