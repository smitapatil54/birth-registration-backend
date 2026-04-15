// File: src/main/java/com/example/birthregistrationbackend/controller/UserController.java

package com.example.birthregistrationbackend.controller;

import com.example.birthregistrationbackend.entity.User;
import com.example.birthregistrationbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {

        Map<String, Object> response = new HashMap<>();

        try {

            User existing = repository.findByEmail(user.getEmail());

            if (existing != null) {
                response.put("message", "Email already exists");
                return response;
            }

            User saved = repository.save(user);

            response.put("message", "Registration Success");
            response.put("id", saved.getId());
            response.put("name", saved.getName());
            response.put("email", saved.getEmail());
            response.put("mobile", saved.getMobile());
            response.put("role", saved.getRole());

        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", e.getMessage());
        }

        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {

        Map<String, Object> response = new HashMap<>();

        try {

            User existing = repository.findByEmailAndPassword(
                    user.getEmail(),
                    user.getPassword()
            );

            if (existing == null) {
                response.put("message", "Login Failed");
                return response;
            }

            response.put("message", "Login Success");
            response.put("id", existing.getId());
            response.put("name", existing.getName());
            response.put("email", existing.getEmail());
            response.put("mobile", existing.getMobile());
            response.put("role", existing.getRole());

        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", e.getMessage());
        }

        return response;
    }
}