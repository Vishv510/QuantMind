package com.stock.stock.exception;

public class StockAlreadyExistsException extends RuntimeException {
    public StockAlreadyExistsException(String symbol) {
        super("A stock with this symbol already exists: " + symbol);
    }
}
