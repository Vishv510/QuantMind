package com.stock.notification.dto;

import com.stock.notification.model.Alert;
import com.stock.notification.model.AlertConditionType;

import java.math.BigDecimal;
import java.time.Instant;

public record AlertDto(
        Long id,
        String userId,
        String symbol,
        AlertConditionType conditionType,
        BigDecimal threshold,
        boolean active,
        Instant createdAt
) {
    public static AlertDto from(Alert alert) {
        return new AlertDto(
                alert.getId(),
                alert.getUserId(),
                alert.getSymbol(),
                alert.getConditionType(),
                alert.getThreshold(),
                alert.isActive(),
                alert.getCreatedAt()
        );
    }
}
