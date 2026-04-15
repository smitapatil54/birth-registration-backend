package com.example.birthregistrationbackend.controller;

import com.example.birthregistrationbackend.entity.BirthRegistration;
import com.example.birthregistrationbackend.repository.BirthRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bmc")
@CrossOrigin("*")
public class BmcVerificationController {

    @Autowired
    private BirthRegistrationRepository repository;

    // BMC dashboard me sirf hospital approved applications dikhengi
    @GetMapping("/pending")
    public List<BirthRegistration> getPendingApplications() {
        return repository.findByStatus("Pending BMC Verification");
    }

    // BMC approve karega to certificate generate hoga
    @PutMapping("/approve/{id}")
    public BirthRegistration approveApplication(@PathVariable Long id) {

        BirthRegistration application =
                repository.findById(id).orElse(null);

        if (application == null) {
            return null;
        }

        application.setStatus("Certificate Generated");

        // Unique certificate number generate
        application.setApplicationId(
                "CERT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase()
        );

        return repository.save(application);
    }

    // Reject by BMC
    @PutMapping("/reject/{id}")
    public BirthRegistration rejectApplication(@PathVariable Long id) {

        BirthRegistration application =
                repository.findById(id).orElse(null);

        if (application == null) {
            return null;
        }

        application.setStatus("Rejected By BMC");

        return repository.save(application);
    }

    // User dashboard ke liye single application
    @GetMapping("/{id}")
    public BirthRegistration getApplication(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}