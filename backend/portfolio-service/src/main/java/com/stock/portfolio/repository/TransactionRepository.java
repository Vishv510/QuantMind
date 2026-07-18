package com.stock.portfolio.repository;
import com.stock.portfolio.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface TransactionRepository extends JpaRepository<Transaction, UUID> { List<Transaction> findByPortfolioIdOrderByExecutedAtDesc(UUID portfolioId); }
