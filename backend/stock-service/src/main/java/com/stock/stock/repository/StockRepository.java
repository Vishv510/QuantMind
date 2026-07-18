package com.stock.stock.repository;

import com.stock.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, UUID> {
    Optional<Stock> findBySymbol(String symbol);
    boolean existsBySymbol(String symbol);
    List<Stock> findBySymbolContainingIgnoreCaseOrCompanyNameContainingIgnoreCaseOrderBySymbolAsc(String symbol, String companyName);
    List<Stock> findAllByOrderBySymbolAsc();
}
