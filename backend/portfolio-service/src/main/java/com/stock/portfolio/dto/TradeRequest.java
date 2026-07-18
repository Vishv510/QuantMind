package com.stock.portfolio.dto;
import jakarta.validation.constraints.*; import java.math.BigDecimal; import java.util.UUID;
public record TradeRequest(@NotNull UUID userId, @NotBlank @Pattern(regexp="^[A-Za-z]{1,10}$") String symbol, @NotNull @DecimalMin("0.0001") BigDecimal quantity, @NotNull @DecimalMin("0.0001") BigDecimal price) { }
