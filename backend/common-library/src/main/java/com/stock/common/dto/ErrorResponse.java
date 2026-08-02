package com.stock.common.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Standard error response DTO
 */
@Data
@NoArgsConstructor
public class ErrorResponse {

    private String errorCode;
    private String errorMessage;
    private String details;
    private long timestamp;

    public ErrorResponse(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timestamp = System.currentTimeMillis();
    }

    public ErrorResponse(String errorCode, String errorMessage, String details, long timestamp) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.details = details;
        this.timestamp = timestamp;
    }
}
