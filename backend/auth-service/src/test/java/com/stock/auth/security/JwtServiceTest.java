package com.stock.auth.security;

import com.stock.auth.config.JwtProperties;
import com.stock.auth.entity.Role;
import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
class JwtServiceTest {

    private JwtService jwtService;
    private UserPrincipal principal;

    @BeforeEach
    void setUp() {
        jwtService = new JwtService(new JwtProperties(
                "this-is-a-test-secret-that-is-at-least-thirty-two-bytes-long",
                60_000));
        jwtService.initialize();

        principal = UserPrincipal.of(
                UUID.randomUUID(), "trader", "unused", "trader@example.com", Role.USER, true);
    }

    @Test
    void generatesAndValidatesTokenForItsSubject() {
        String token = jwtService.generateToken(principal);

        assertEquals("trader", jwtService.extractSubject(token));
        org.junit.jupiter.api.Assertions.assertTrue(jwtService.isTokenValid(token, principal));
    }

    @Test
    void rejectsMalformedToken() {
        assertThrows(JwtException.class, () -> jwtService.extractSubject("not-a-jwt"));
    }
}
