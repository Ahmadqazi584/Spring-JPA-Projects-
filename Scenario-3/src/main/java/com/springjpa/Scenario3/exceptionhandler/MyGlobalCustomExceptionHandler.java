package com.springjpa.Scenario3.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyGlobalCustomExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> myCustomResourceNotFound(ResourceNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
