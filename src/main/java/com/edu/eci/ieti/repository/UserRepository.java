package com.edu.eci.ieti.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<user, String> {
    Optional<user> findByEmail(String email); // Método para buscar por email

}
