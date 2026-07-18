package com.stock.notification.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stock.notification.dto.StockUpdateEvent;
import com.stock.notification.service.AlertService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StockPriceUpdateConsumer {
    private final ObjectMapper objectMapper;
    private final AlertService alertService;

    public StockPriceUpdateConsumer(ObjectMapper objectMapper, AlertService alertService) {
        this.objectMapper = objectMapper;
        this.alertService = alertService;
    }

    @KafkaListener(topics = "${app.kafka.stock-price-topic:stock.price-updates}", groupId = "${spring.kafka.consumer.group-id:notification-service}")
    public void consume(byte[] payload) throws Exception {
        StockUpdateEvent event = objectMapper.readValue(payload, StockUpdateEvent.class);
        alertService.evaluate(event);
    }
}
