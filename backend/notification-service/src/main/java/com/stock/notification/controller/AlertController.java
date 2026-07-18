package com.stock.notification.controller;

import com.stock.notification.dto.AlertDto;
import com.stock.notification.dto.CreateAlertRequest;
import com.stock.notification.service.AlertService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {
    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping
    public List<AlertDto> getAlerts(@RequestParam String userId) {
        return alertService.getAlertsForUser(userId);
    }

    @PostMapping
    public ResponseEntity<AlertDto> createAlert(@Valid @RequestBody CreateAlertRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alertService.createAlert(request));
    }

    @DeleteMapping("/{alertId}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long alertId, @RequestParam String userId) {
        alertService.deleteAlert(alertId, userId);
        return ResponseEntity.noContent().build();
    }
}
