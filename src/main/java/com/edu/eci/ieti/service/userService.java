package com.edu.eci.ieti.service;

import com.edu.eci.ieti.repository.user;

import java.util.List;
import java.util.Optional;

public interface userService {
    user save(user user);
    List<user> all();
    Optional<user> findById(String id);
    void deleteById(String id);
    user update(String id, user user);
}
