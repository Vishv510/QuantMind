package com.stock.stock.service;

import com.stock.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class MockStockPriceSimulator {

    private final StockRepository stockRepository;
    private final StockService stockService;
    private final boolean enabled;

    public MockStockPriceSimulator(
            StockRepository stockRepository,
            StockService stockService,
            @Value("${app.price-simulator.enabled:true}") boolean enabled
    ) {
        this.stockRepository = stockRepository;
        this.stockService = stockService;
        this.enabled = enabled;
    }

    @Scheduled(fixedDelayString = "${app.price-simulator.fixed-delay-ms:5000}")
    public void simulatePrices() {
        if (!enabled) {
            return;
        }
        stockRepository.findAllByOrderBySymbolAsc().forEach(stock -> {
            BigDecimal percentage = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(-0.02, 0.02));
            BigDecimal nextPrice = stock.getCurrentPrice().multiply(BigDecimal.ONE.add(percentage))
                    .max(new BigDecimal("0.0001"))
                    .setScale(4, RoundingMode.HALF_UP);
            stockService.updatePrice(stock.getSymbol(), nextPrice);
        });
    }
}
