package com.edu.eci.ieti.security;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Base64;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

class JWTUtilTest {

    private JWTUtil jwtUtil;
    private UserDetails userDetails;
    private String secretKey;

    @BeforeEach
    void setUp() {
        // 🔐 Simulación de la clave secreta en Base64 (como en application.properties)
        secretKey = Base64.getEncoder().encodeToString("mySuperSecretKeyForJWTAuthentication".getBytes());

        jwtUtil = new JWTUtil(secretKey);
        userDetails = new User("testuser", "password", new java.util.ArrayList<>());
    }

    @Test
    void testGenerateToken() {
        String token = jwtUtil.generateToken(userDetails);
        assertNotNull(token);
    }

    @Test
    void testExtractUsername() {
        String token = jwtUtil.generateToken(userDetails);
        String username = jwtUtil.extractUsername(token);
        assertEquals("testuser", username);
    }

    @Test
    void testTokenValidity() {
        String token = jwtUtil.generateToken(userDetails);
        assertTrue(jwtUtil.validateToken(token, userDetails));
    }

}
