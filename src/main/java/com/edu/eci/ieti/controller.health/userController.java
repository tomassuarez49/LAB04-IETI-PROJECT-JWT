package com.edu.eci.ieti.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.eci.ieti.repository.user;
import com.edu.eci.ieti.service.userService;

@RestController
@RequestMapping("/users")
public class userController {

    private final userService userService;

    @Autowired
    public userController(userService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<user> createUser(@RequestBody user user) {
        user createdUser = userService.save(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<user>> getAllUsers() {
        List<user> users = userService.all();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<user> findById(@PathVariable String id) {
        Optional<user> userOpt = userService.findById(id);
        return userOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<user> updateUser(@PathVariable String id, @RequestBody user user) {
        user updatedUser = userService.update(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
