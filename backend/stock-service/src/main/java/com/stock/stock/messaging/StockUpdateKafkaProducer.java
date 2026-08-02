package com.stock.stock.messaging;

import com.stock.stock.dto.StockUpdateEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import java.util.Objects;

@Component
public class StockUpdateKafkaProducer {

    private final KafkaTemplate<String, StockUpdateEvent> kafkaTemplate;
    private final String topic;

    public StockUpdateKafkaProducer(
            KafkaTemplate<String, StockUpdateEvent> kafkaTemplate,
            @Value("${app.kafka.stock-price-topic:stock.price-updates}") String topic
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void publish(StockUpdateEvent event) {
        Objects.requireNonNull(event, "event");
        String symbol = Objects.requireNonNull(event.symbol(), "event.symbol");
        kafkaTemplate.send(
                Objects.requireNonNull(topic, "topic"),
                symbol,
                event
        );
    }
}
