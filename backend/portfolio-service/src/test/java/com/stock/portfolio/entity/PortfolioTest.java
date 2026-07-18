package com.stock.portfolio.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PortfolioTest {

    @Test
    void buyCalculatesWeightedAverageCost() {
        Portfolio portfolio = Portfolio.create(UUID.randomUUID(), "AAPL", decimal("10"), decimal("100"));

        portfolio.buy(decimal("10"), decimal("120"));

        assertEquals(decimal("20"), portfolio.getQuantity());
        assertEquals(decimal("110"), portfolio.getAverageBuyPrice());
    }

    @Test
    void sellCalculatesAndAccumulatesRealizedPnl() {
        Portfolio portfolio = Portfolio.create(UUID.randomUUID(), "MSFT", decimal("10"), decimal("100"));

        BigDecimal realized = portfolio.sell(decimal("4"), decimal("125"));

        assertEquals(decimal("6"), portfolio.getQuantity());
        assertEquals(decimal("100"), realized);
        assertEquals(decimal("100"), portfolio.getRealizedPnl());
    }

    @Test
    void sellRejectsQuantityGreaterThanHolding() {
        Portfolio portfolio = Portfolio.create(UUID.randomUUID(), "TSLA", decimal("1"), decimal("100"));

        assertThrows(IllegalArgumentException.class, () -> portfolio.sell(decimal("2"), decimal("100")));
    }

    private BigDecimal decimal(String value) {
        return new BigDecimal(value).setScale(4, RoundingMode.HALF_UP);
    }
}
