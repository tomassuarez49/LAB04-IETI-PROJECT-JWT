package com.edu.eci.ieti.service;

import com.edu.eci.ieti.repository.UserRepository;
import com.edu.eci.ieti.repository.user;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest  // 🔥 Carga toda la aplicación (incluyendo MongoDB)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class userServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private userService userService;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();  // Limpia la base de datos antes de cada prueba
    }

    @Test
    void testSaveUser() {
        user testUser = new user(null, "John Doe", "john@example.com");
        user savedUser = userService.save(testUser);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isNotNull();  // Verifica que se generó un ID en MongoDB
        assertThat(savedUser.getName()).isEqualTo("John Doe");
    }

    @Test
    void testFindById() {
        user testUser = new user(null, "Jane Doe", "jane@example.com");
        user savedUser = userService.save(testUser);

        Optional<user> foundUser = userService.findById(savedUser.getId());

        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getName()).isEqualTo("Jane Doe");
    }

    @Test
    void testDeleteUser() {
        user testUser = new user(null, "Mark Doe", "mark@example.com");
        user savedUser = userService.save(testUser);

        userService.deleteById(savedUser.getId());

        Optional<user> deletedUser = userService.findById(savedUser.getId());
        assertThat(deletedUser).isEmpty();  // Verifica que el usuario fue eliminado
    }
}
