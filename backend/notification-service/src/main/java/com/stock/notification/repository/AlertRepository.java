package com.stock.notification.repository;

import com.stock.notification.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByActiveTrueAndSymbolIgnoreCase(String symbol);

    List<Alert> findByUserIdAndActiveTrueOrderByCreatedAtDesc(String userId);
}
