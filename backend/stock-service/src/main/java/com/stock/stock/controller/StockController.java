package com.stock.stock.controller;

import com.stock.common.dto.ApiResponse;
import com.stock.stock.dto.CreateStockRequest;
import com.stock.stock.dto.StockResponse;
import com.stock.stock.dto.UpdateStockRequest;
import com.stock.stock.service.StockService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StockResponse>> create(@Valid @RequestBody CreateStockRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created(stockService.create(request)));
    }

    @GetMapping("/{symbol}")
    public ApiResponse<StockResponse> getBySymbol(@PathVariable String symbol) {
        return ApiResponse.success(stockService.getBySymbol(symbol), "Stock retrieved successfully");
    }

    @GetMapping
    public ApiResponse<List<StockResponse>> search(@RequestParam(required = false) String query) {
        return ApiResponse.success(stockService.search(query), "Stocks retrieved successfully");
    }

    @PutMapping("/{symbol}")
    public ApiResponse<StockResponse> update(@PathVariable String symbol, @Valid @RequestBody UpdateStockRequest request) {
        return ApiResponse.success(stockService.update(symbol, request), "Stock updated successfully");
    }

    @DeleteMapping("/{symbol}")
    public ResponseEntity<Void> delete(@PathVariable String symbol) {
        stockService.delete(symbol);
        return ResponseEntity.noContent().build();
    }
}
