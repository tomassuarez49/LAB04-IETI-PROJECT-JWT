package com.edu.eci.ieti.controller.health;

import com.edu.eci.ieti.repository.UserRepository;
import com.edu.eci.ieti.service.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = HealthControllerTest.Config.class)  // 🚀 Carga la configuración de prueba
public class HealthControllerTest {

    @MockBean
    private UserRepository userRepository;  // 🔹 Simula UserRepository

    @MockBean
    private CustomUserDetailsService customUserDetailsService;  // 🔹 Simula el servicio de autenticación

    @Test
    public void contextLoads() {
        assertThat(userRepository).isNotNull();
        assertThat(customUserDetailsService).isNotNull();
    }

    @Configuration
    static class Config {
        @Bean
        public HealthController healthController() {
            return new HealthController();
        }
    }
}
