package com.stock.stock.service;

import com.stock.stock.dto.CreateStockRequest;
import com.stock.stock.dto.StockResponse;
import com.stock.stock.dto.StockUpdateEvent;
import com.stock.stock.dto.UpdateStockRequest;
import com.stock.stock.entity.Stock;
import com.stock.stock.exception.StockNotFoundException;
import com.stock.stock.exception.StockAlreadyExistsException;
import com.stock.stock.repository.StockRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.List;
import java.util.Locale;

@Service
public class StockService {

    private final StockRepository stockRepository;
    private final ApplicationEventPublisher eventPublisher;

    public StockService(StockRepository stockRepository, ApplicationEventPublisher eventPublisher) {
        this.stockRepository = stockRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public StockResponse create(CreateStockRequest request) {
        String symbol = normalizeSymbol(request.symbol());
        if (stockRepository.existsBySymbol(symbol)) {
            throw new StockAlreadyExistsException(symbol);
        }
        BigDecimal openingPrice = request.openingPrice().setScale(4, RoundingMode.HALF_UP);
        return toResponse(stockRepository.save(Stock.create(symbol, request.companyName().trim(), openingPrice)));
    }

    @Transactional(readOnly = true)
    @Cacheable(cacheNames = "stocks", key = "#symbol.toUpperCase()")
    public StockResponse getBySymbol(String symbol) {
        return toResponse(findBySymbol(symbol));
    }

    @Transactional(readOnly = true)
    public List<StockResponse> search(String query) {
        List<Stock> stocks = (query == null || query.isBlank())
                ? stockRepository.findAllByOrderBySymbolAsc()
                : stockRepository.findBySymbolContainingIgnoreCaseOrCompanyNameContainingIgnoreCaseOrderBySymbolAsc(query.trim(), query.trim());
        return stocks.stream().map(this::toResponse).toList();
    }

    @Transactional
    @CacheEvict(cacheNames = "stocks", key = "#symbol.toUpperCase()")
    public StockResponse update(String symbol, UpdateStockRequest request) {
        Stock stock = findBySymbol(symbol);
        stock.updateDetails(request.companyName().trim());
        return toResponse(stock);
    }

    @Transactional
    @CacheEvict(cacheNames = "stocks", key = "#symbol.toUpperCase()")
    public void delete(String symbol) {
        stockRepository.delete(findBySymbol(symbol));
    }

    @Transactional
    @CacheEvict(cacheNames = "stocks", key = "#symbol.toUpperCase()")
    public void updatePrice(String symbol, BigDecimal newPrice) {
        Stock stock = findBySymbol(symbol);
        stock.updatePrice(newPrice.setScale(4, RoundingMode.HALF_UP));
        eventPublisher.publishEvent(toEvent(stock));
    }

    private Stock findBySymbol(String symbol) {
        String normalizedSymbol = normalizeSymbol(symbol);
        return stockRepository.findBySymbol(normalizedSymbol)
                .orElseThrow(() -> new StockNotFoundException(normalizedSymbol));
    }

    private String normalizeSymbol(String symbol) {
        return symbol.trim().toUpperCase(Locale.ROOT);
    }

    private StockResponse toResponse(Stock stock) {
        BigDecimal change = stock.getCurrentPrice().subtract(stock.getPreviousClose()).setScale(4, RoundingMode.HALF_UP);
        BigDecimal changePercent = change.multiply(BigDecimal.valueOf(100))
                .divide(stock.getPreviousClose(), 4, RoundingMode.HALF_UP);
        return new StockResponse(stock.getId(), stock.getSymbol(), stock.getCompanyName(), stock.getCurrentPrice(),
                stock.getPreviousClose(), change, changePercent, stock.getLastUpdatedAt());
    }

    private StockUpdateEvent toEvent(Stock stock) {
        BigDecimal changePercent = stock.getCurrentPrice().subtract(stock.getPreviousClose())
                .multiply(BigDecimal.valueOf(100))
                .divide(stock.getPreviousClose(), 4, RoundingMode.HALF_UP);
        return new StockUpdateEvent(stock.getId(), stock.getSymbol(), stock.getCurrentPrice(),
                stock.getPreviousClose(), changePercent, Instant.now());
    }
}
