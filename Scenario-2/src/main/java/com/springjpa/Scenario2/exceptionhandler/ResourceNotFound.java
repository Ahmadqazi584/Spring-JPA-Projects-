package com.springjpa.Scenario2.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String noAnyCourseExists) {
        super(noAnyCourseExists);
    }
}
