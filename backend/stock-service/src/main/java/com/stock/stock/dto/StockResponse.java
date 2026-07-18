package com.stock.stock.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record StockResponse(
        UUID id, String symbol, String companyName, BigDecimal currentPrice,
        BigDecimal previousClose, BigDecimal change, BigDecimal changePercent, Instant lastUpdatedAt
) implements Serializable {
}
