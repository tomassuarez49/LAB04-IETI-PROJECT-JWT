package com.edu.eci.ieti.controller.health;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.eci.ieti.repository.user;
import com.edu.eci.ieti.security.JWTUtil;
import com.edu.eci.ieti.service.userService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final userService userService;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public com.edu.eci.ieti.controller.health.AuthResponse login(@RequestBody AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException("Credenciales inválidas", e);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(userDetails);

        return new com.edu.eci.ieti.controller.health.AuthResponse(token);
    }

    @PostMapping("/register")
    public String register(@RequestBody com.edu.eci.ieti.controller.health.RegisterRequest request) {
        user newUser = new user();
        newUser.setName(request.getUsername());
        newUser.setEmail(request.getUsername()); // Suponiendo que el email es el username
        newUser.setPassword(passwordEncoder.encode(request.getPassword())); // Deberías encriptarlo antes de guardarlo
        userService.save(newUser);
        return "Usuario registrado exitosamente";
    }
}
