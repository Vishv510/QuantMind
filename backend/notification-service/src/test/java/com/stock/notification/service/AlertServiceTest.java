package com.stock.notification.service;

import com.stock.notification.dto.AlertDto;
import com.stock.notification.dto.CreateAlertRequest;
import com.stock.notification.model.Alert;
import com.stock.notification.model.AlertConditionType;
import com.stock.notification.repository.AlertRepository;
import com.stock.notification.dto.StockUpdateEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlertServiceTest {

    @Mock
    private AlertRepository repository;

    @Mock
    private SimpMessagingTemplate messagingTemplate;

    @InjectMocks
    private AlertService alertService;

    @Test
    void shouldCreateAlertFromRequest() {
        CreateAlertRequest request = new CreateAlertRequest("user-1", "AAPL", "above", new BigDecimal("100"));
        when(repository.save(any(Alert.class))).thenAnswer(invocation -> {
            Alert alert = invocation.getArgument(0);
            alert.setId(1L);
            return alert;
        });

        AlertDto dto = alertService.createAlert(request);

        assertEquals("AAPL", dto.symbol());
        assertEquals(AlertConditionType.ABOVE, dto.conditionType());
        assertEquals("user-1", dto.userId());
    }

    @Test
    void shouldPushAlertWhenPriceMatchesCondition() {
        Alert alert = new Alert();
        alert.setId(1L);
        alert.setUserId("user-1");
        alert.setSymbol("AAPL");
        alert.setConditionType(AlertConditionType.ABOVE);
        alert.setThreshold(new BigDecimal("100"));
        alert.setActive(true);

        when(repository.findByActiveTrueAndSymbolIgnoreCase("AAPL")).thenReturn(List.of(alert));

        StockUpdateEvent event = new StockUpdateEvent(java.util.UUID.randomUUID(), "AAPL", new BigDecimal("101"), new BigDecimal("100"), new BigDecimal("1"), java.time.Instant.now());

        alertService.evaluate(event);

        verify(messagingTemplate).convertAndSend(any(String.class), any(Object.class));
    }
}
