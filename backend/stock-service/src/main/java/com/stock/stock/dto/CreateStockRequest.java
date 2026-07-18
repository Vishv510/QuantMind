package com.stock.stock.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateStockRequest(
        @NotBlank @Pattern(regexp = "^[A-Za-z]{1,10}$", message = "symbol must contain 1 to 10 letters") String symbol,
        @NotBlank @Size(max = 200) String companyName,
        @DecimalMin(value = "0.0001") BigDecimal openingPrice
) {
}
