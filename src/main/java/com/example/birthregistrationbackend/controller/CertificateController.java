package com.example.birthregistrationbackend.controller;

import com.example.birthregistrationbackend.entity.Certificate;
import com.example.birthregistrationbackend.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/certificate")
@CrossOrigin("*")
public class CertificateController {

    @Autowired
    private CertificateRepository repository;

    // SAVE CERTIFICATE
    @PostMapping("/save")
    public ResponseEntity<?> saveCertificate(@RequestBody Certificate certificate) {
        try {
            Certificate saved = repository.save(certificate);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving certificate: " + e.getMessage());
        }
    }

    // GET CERTIFICATE BY BIRTH ID
    @GetMapping("/birth/{birthRegistrationId}")
    public ResponseEntity<?> getCertificateByBirthRegistrationId(
            @PathVariable Long birthRegistrationId
    ) {
        try {
            Certificate cert = repository.findByBirthRegistrationId(birthRegistrationId);

            if (cert == null) {
                return ResponseEntity.status(404).body("Certificate not found");
            }

            return ResponseEntity.ok(cert);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Server Error: " + e.getMessage());
        }
    }
}