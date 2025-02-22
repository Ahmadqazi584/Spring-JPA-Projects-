package com.springjpa.Scenario2.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyGlobalCustomExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> myCustomResouceNotFound(ResourceNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
