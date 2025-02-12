package com.edu.eci.ieti.controller.health;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.mockito.Mockito;
import com.edu.eci.ieti.repository.UserRepository;

@TestConfiguration
public class UserRepositoryTestConfig {

    @Bean
    public UserRepository userRepository() {
        return Mockito.mock(UserRepository.class);
    }
}
