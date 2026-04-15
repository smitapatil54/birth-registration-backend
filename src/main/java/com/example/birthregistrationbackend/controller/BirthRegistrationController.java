// File: src/main/java/com/example/birthregistrationbackend/controller/BirthRegistrationController.java

package com.example.birthregistrationbackend.controller;

import com.example.birthregistrationbackend.entity.BirthRegistration;
import com.example.birthregistrationbackend.repository.BirthRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/birth")
@CrossOrigin("*")
public class BirthRegistrationController {

    @Autowired
    private BirthRegistrationRepository repository;

    @PostMapping("/save")
    public BirthRegistration save(@RequestBody BirthRegistration registration) {

        registration.setApplicationId(
                "APP-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase()
        );

        registration.setStatus("Pending Hospital Verification");

        return repository.save(registration);
    }

    @GetMapping("/all")
    public List<BirthRegistration> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public BirthRegistration getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/user/{userId}")
    public BirthRegistration getByUserId(@PathVariable Long userId) {
        return repository.findTopByUserIdOrderByIdDesc(userId);
    }

    @PutMapping("/status/{id}")
    public BirthRegistration updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {

        BirthRegistration registration =
                repository.findById(id).orElse(null);

        if (registration != null) {
            registration.setStatus(status);
            return repository.save(registration);
        }

        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}