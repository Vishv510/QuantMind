package com.stock.stock.exception;

import com.stock.common.dto.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StockNotFoundException.class)
    ResponseEntity<ErrorResponse> notFound(StockNotFoundException exception) {
        return error(HttpStatus.NOT_FOUND, "STOCK_NOT_FOUND", exception.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    ResponseEntity<ErrorResponse> conflict(DataIntegrityViolationException exception) {
        return error(HttpStatus.CONFLICT, "STOCK_CONFLICT", "A stock with this symbol already exists");
    }

    @ExceptionHandler(StockAlreadyExistsException.class)
    ResponseEntity<ErrorResponse> conflict(StockAlreadyExistsException exception) {
        return error(HttpStatus.CONFLICT, "STOCK_CONFLICT", exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorResponse> validation(MethodArgumentNotValidException exception) {
        String details = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return error(HttpStatus.BAD_REQUEST, "VALIDATION_FAILED", details);
    }

    private ResponseEntity<ErrorResponse> error(HttpStatus status, String code, String details) {
        return ResponseEntity.status(status)
                .body(new ErrorResponse(code, status.getReasonPhrase(), details, System.currentTimeMillis()));
    }
}
