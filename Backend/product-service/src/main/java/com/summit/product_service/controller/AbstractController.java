package com.summit.product_service.controller;

import com.summit.product_service.exception.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



public abstract class AbstractController {
    protected <T> ResponseEntity<T> successResponse(T data, HttpStatus status) {
        return new ResponseEntity<>(data, status);

    }
    protected ResponseEntity<Void> noContentResponse() {
        return ResponseEntity.noContent().build();
    }
    protected ResponseEntity<APIResponse> buildErrorResponse(String message, HttpStatus status, String details) {
        APIResponse errorDetails = new APIResponse(status.value(), message, details);
        return new ResponseEntity<>(errorDetails, status);
    }
    protected <T> ResponseEntity<T> createdResponse(T data){
        return new ResponseEntity<>(data,HttpStatus.CREATED);
    }
}