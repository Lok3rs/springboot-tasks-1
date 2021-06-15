package com.codecool.spingboot_tasks.error_handling.handler;

import com.codecool.spingboot_tasks.error_handling.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<ErrorDto> handleException2(Exception e) {
        System.out.println(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(new ErrorDto("runtime", e.getMessage()));
    }

    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<ErrorDto> handleRuntimeException(Exception e) {
        System.out.println(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(new ErrorDto("runtime", e.getMessage()));
    }

    @ExceptionHandler({ NullPointerException.class })
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        System.out.println(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(new ErrorDto("test", e.getMessage()));
    }
}
