package com.stock.auth.dto;

import com.stock.auth.entity.Role;

import java.util.UUID;

public record AuthResponse(
        String accessToken,
        String tokenType,
        long expiresIn,
        UUID userId,
        String username,
        String email,
        Role role
) {
}
