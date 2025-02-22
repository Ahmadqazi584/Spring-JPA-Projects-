package com.springjpa.Scenario1.exceptionhanlder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MyGlobalCustomExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<APIResponse> MyResourceNotFoundException(ResourceNotFound ex) {
        APIResponse apiResponse = new APIResponse(ex.getMessage(), false, LocalDateTime.now());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

}
