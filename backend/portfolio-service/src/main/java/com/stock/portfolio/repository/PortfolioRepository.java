package com.stock.portfolio.repository;
import com.stock.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface PortfolioRepository extends JpaRepository<Portfolio, UUID> {
    Optional<Portfolio> findByUserIdAndSymbol(UUID userId, String symbol);
    List<Portfolio> findByUserIdOrderBySymbolAsc(UUID userId);
    List<Portfolio> findBySymbol(String symbol);
}
