package com.stock.notification.service;

import com.stock.notification.model.Alert;
import com.stock.notification.model.AlertConditionType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlertEvaluationEngineTest {

    private final AlertEvaluationEngine engine = new AlertEvaluationEngine();

    @Test
    void shouldTriggerWhenPriceCrossesAboveThreshold() {
        Alert alert = new Alert();
        alert.setConditionType(AlertConditionType.ABOVE);
        alert.setThreshold(new BigDecimal("100"));

        assertTrue(engine.shouldTrigger(alert, new BigDecimal("101")));
        assertFalse(engine.shouldTrigger(alert, new BigDecimal("99")));
    }

    @Test
    void shouldTriggerWhenPriceCrossesBelowThreshold() {
        Alert alert = new Alert();
        alert.setConditionType(AlertConditionType.BELOW);
        alert.setThreshold(new BigDecimal("100"));

        assertTrue(engine.shouldTrigger(alert, new BigDecimal("99")));
        assertFalse(engine.shouldTrigger(alert, new BigDecimal("101")));
    }
}
