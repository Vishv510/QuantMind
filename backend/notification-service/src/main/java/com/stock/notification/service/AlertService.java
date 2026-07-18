package com.stock.notification.service;

import com.stock.notification.dto.AlertDto;
import com.stock.notification.dto.AlertNotification;
import com.stock.notification.dto.CreateAlertRequest;
import com.stock.notification.dto.StockUpdateEvent;
import com.stock.notification.model.Alert;
import com.stock.notification.model.AlertConditionType;
import com.stock.notification.repository.AlertRepository;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class AlertService {
    private final AlertRepository repository;
    private final SimpMessagingTemplate messagingTemplate;
    private final AlertEvaluationEngine evaluationEngine;

    public AlertService(AlertRepository repository, SimpMessagingTemplate messagingTemplate) {
        this(repository, messagingTemplate, new AlertEvaluationEngine());
    }

    public AlertService(AlertRepository repository, SimpMessagingTemplate messagingTemplate, AlertEvaluationEngine evaluationEngine) {
        this.repository = repository;
        this.messagingTemplate = messagingTemplate;
        this.evaluationEngine = evaluationEngine != null ? evaluationEngine : new AlertEvaluationEngine();
    }

    public List<AlertDto> getAlertsForUser(String userId) {
        return repository.findByUserIdAndActiveTrueOrderByCreatedAtDesc(userId)
                .stream()
                .map(AlertDto::from)
                .toList();
    }

    public AlertDto createAlert(CreateAlertRequest request) {
        Alert alert = new Alert();
        alert.setUserId(request.userId());
        alert.setSymbol(request.symbol().trim().toUpperCase(Locale.ROOT));
        alert.setConditionType(AlertConditionType.from(request.conditionType()));
        alert.setThreshold(request.threshold());
        alert.setActive(true);

        return AlertDto.from(repository.save(alert));
    }

    public void deleteAlert(Long alertId, String userId) {
        Optional<Alert> existing = repository.findById(alertId);
        if (existing.isEmpty() || !userId.equals(existing.get().getUserId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alert not found");
        }

        Alert alert = existing.get();
        alert.setActive(false);
        repository.save(alert);
    }

    public void evaluate(StockUpdateEvent event) {
        List<Alert> alerts = repository.findByActiveTrueAndSymbolIgnoreCase(event.symbol());
        for (Alert alert : alerts) {
            if (evaluationEngine.shouldTrigger(alert, event.currentPrice())) {
                messagingTemplate.convertAndSend(
                        "/topic/alerts/" + alert.getUserId(),
                        new AlertNotification(alert, event)
                );
            }
        }
    }
}
