package com.rmit.assignment.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ServiceExceptionHandler extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServiceExceptionHandler() {
    }

    public ServiceExceptionHandler(String message) {
        super(message);
    }
}
