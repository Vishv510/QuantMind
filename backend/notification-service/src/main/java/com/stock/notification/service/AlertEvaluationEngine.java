package com.stock.notification.service;

import com.stock.notification.model.Alert;
import com.stock.notification.model.AlertConditionType;

import java.math.BigDecimal;

public class AlertEvaluationEngine {
    public boolean shouldTrigger(Alert alert, BigDecimal currentPrice) {
        if (alert == null || alert.getThreshold() == null || currentPrice == null) {
            return false;
        }

        return switch (alert.getConditionType()) {
            case ABOVE -> currentPrice.compareTo(alert.getThreshold()) > 0;
            case BELOW -> currentPrice.compareTo(alert.getThreshold()) < 0;
            case EQUALS -> currentPrice.compareTo(alert.getThreshold()) == 0;
        };
    }
}
