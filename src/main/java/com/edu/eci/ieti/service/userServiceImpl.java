package com.edu.eci.ieti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eci.ieti.repository.UserRepository;
import com.edu.eci.ieti.repository.user;

@Service
public class userServiceImpl implements userService {

    private final UserRepository userRepository;

    @Autowired
    public userServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public user save(user user) {
        return userRepository.save(user);
    }

    @Override
    public List<user> all() {
        return userRepository.findAll();
    }

    @Override
    public Optional<user> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public user update(String id, user user) {
        Optional<user> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            user userToUpdate = existingUser.get();
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            return userRepository.save(userToUpdate);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
