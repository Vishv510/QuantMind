package com.stock.notification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateAlertRequest(
        @NotBlank String userId,
        @NotBlank String symbol,
        @NotBlank String conditionType,
        @NotNull BigDecimal threshold
) {
}
