package com.stock.auth.service;

import com.stock.auth.config.JwtProperties;
import com.stock.auth.dto.AuthResponse;
import com.stock.auth.dto.LoginRequest;
import com.stock.auth.dto.RegisterRequest;
import com.stock.auth.entity.User;
import com.stock.auth.exception.DuplicateResourceException;
import com.stock.auth.repository.UserRepository;
import com.stock.auth.security.JwtService;
import com.stock.auth.security.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final JwtProperties jwtProperties;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            JwtProperties jwtProperties
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.jwtProperties = jwtProperties;
    }

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        String username = normalize(request.username());
        String email = normalize(request.email());

        if (userRepository.existsByUsername(username)) {
            throw new DuplicateResourceException("Username is already in use");
        }
        if (userRepository.existsByEmail(email)) {
            throw new DuplicateResourceException("Email is already in use");
        }

        User user = userRepository.save(User.create(
                username,
                email,
                passwordEncoder.encode(request.password())));

        return createAuthResponse(UserPrincipal.from(user));
    }

    @Transactional(readOnly = true)
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(request.usernameOrEmail(), request.password()));
        return createAuthResponse((UserPrincipal) authentication.getPrincipal());
    }

    private AuthResponse createAuthResponse(UserPrincipal principal) {
        return new AuthResponse(
                jwtService.generateToken(principal),
                "Bearer",
                jwtProperties.expiration() / 1000,
                principal.getId(),
                principal.getUsername(),
                principal.getEmail(),
                principal.getRole());
    }

    private String normalize(String value) {
        return value.trim().toLowerCase(Locale.ROOT);
    }
}
