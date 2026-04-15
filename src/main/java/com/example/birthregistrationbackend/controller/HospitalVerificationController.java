package com.example.birthregistrationbackend.controller;

import com.example.birthregistrationbackend.entity.BirthRegistration;
import com.example.birthregistrationbackend.repository.BirthRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital")
@CrossOrigin("*")
public class HospitalVerificationController {

    @Autowired
    private BirthRegistrationRepository repository;

    // Hospital dashboard me sirf wahi applications dikhengi
    // jinka status Pending Hospital Verification hai
    @GetMapping("/pending")
    public List<BirthRegistration> getPendingApplications() {
        return repository.findByStatus("Pending Hospital Verification");
    }

    // Approve / Reject / Correction
    @PutMapping("/status/{id}")
    public BirthRegistration updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {

        BirthRegistration application =
                repository.findById(id).orElse(null);

        if (application == null) {
            return null;
        }

        if (status.equalsIgnoreCase("APPROVED")) {
            application.setStatus("Pending BMC Verification");

        } else if (status.equalsIgnoreCase("REJECTED")) {
            application.setStatus("Rejected By Hospital");

        } else if (status.equalsIgnoreCase("CORRECTION")) {
            application.setStatus("Correction Requested By Hospital");
        }

        return repository.save(application);
    }

    // Delete old applications if needed
    @DeleteMapping("/delete/{id}")
    public String deleteApplication(@PathVariable Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Application Deleted Successfully";
        }

        return "Application Not Found";
    }
}