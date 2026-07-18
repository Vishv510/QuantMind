package com.stock.stock.service;

import com.stock.stock.dto.CreateStockRequest;
import com.stock.stock.dto.StockResponse;
import com.stock.stock.dto.StockUpdateEvent;
import com.stock.stock.entity.Stock;
import com.stock.stock.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StockServiceTest {

    @Test
    void createsStockUsingNormalizedSymbol() {
        List<Stock> saved = new ArrayList<>();
        StockRepository repository = repository((method, arguments) -> switch (method.getName()) {
            case "existsBySymbol" -> false;
            case "save" -> {
                saved.add((Stock) arguments[0]);
                yield arguments[0];
            }
            default -> throw new UnsupportedOperationException(method.getName());
        });

        StockService service = new StockService(repository, event -> { });
        StockResponse response = service.create(new CreateStockRequest("aapl", "Apple Inc.", new BigDecimal("189.12")));

        assertEquals("AAPL", saved.get(0).getSymbol());
        assertEquals(new BigDecimal("189.1200"), response.currentPrice());
    }

    @Test
    void priceUpdatePublishesPriceEventAfterUpdatingEntity() {
        Stock stock = Stock.create("MSFT", "Microsoft", new BigDecimal("100.0000"));
        List<Object> events = new ArrayList<>();
        StockRepository repository = repository((method, arguments) -> switch (method.getName()) {
            case "findBySymbol" -> Optional.of(stock);
            default -> throw new UnsupportedOperationException(method.getName());
        });
        ApplicationEventPublisher publisher = events::add;
        StockService service = new StockService(repository, publisher);

        service.updatePrice("msft", new BigDecimal("105.5000"));

        assertEquals(new BigDecimal("105.5000"), stock.getCurrentPrice());
        assertEquals(1, events.size());
        StockUpdateEvent event = (StockUpdateEvent) events.get(0);
        assertEquals("MSFT", event.symbol());
        assertEquals(new BigDecimal("5.5000"), event.changePercent());
    }

    @SuppressWarnings("unchecked")
    private StockRepository repository(RepositoryInvocation invocation) {
        return (StockRepository) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class<?>[]{StockRepository.class},
                (proxy, method, arguments) -> invocation.invoke(method, arguments));
    }

    @FunctionalInterface
    private interface RepositoryInvocation {
        Object invoke(java.lang.reflect.Method method, Object[] arguments) throws Throwable;
    }
}
