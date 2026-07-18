package com.stock.stock.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateStockRequest(@NotBlank @Size(max = 200) String companyName) {
}
