package com.stock.common.exception;

/**
 * Base exception for all stock analytics application exceptions
 */
public class StockAnalyticsException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public StockAnalyticsException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public StockAnalyticsException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public StockAnalyticsException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessage = message;
    }

    public StockAnalyticsException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
