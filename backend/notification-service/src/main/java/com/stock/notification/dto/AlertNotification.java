package com.stock.notification.dto;

import com.stock.notification.model.Alert;

import java.math.BigDecimal;
import java.time.Instant;

public record AlertNotification(
        String userId,
        String symbol,
        String conditionType,
        BigDecimal threshold,
        BigDecimal currentPrice,
        Instant triggeredAt,
        String message
) {
    public AlertNotification(Alert alert, StockUpdateEvent event) {
        this(
                alert.getUserId(),
                alert.getSymbol(),
                alert.getConditionType().name(),
                alert.getThreshold(),
                event.currentPrice(),
                Instant.now(),
                "Alert triggered for " + alert.getSymbol() + " at " + event.currentPrice()
        );
    }
}
