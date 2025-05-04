package com.summit.product_service.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class APIResponse {
    private final int status;
    private final String message;
    private final String details;

    public APIResponse(int status, String message, String details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }
}
