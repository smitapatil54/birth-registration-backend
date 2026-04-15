package com.example.birthregistrationbackend.controller;

import com.example.birthregistrationbackend.entity.Certificate;
import com.example.birthregistrationbackend.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/certificate")
@CrossOrigin("*")
public class CertificateController {

    @Autowired
    private CertificateRepository repository;

    @PostMapping("/save")
    public Certificate saveCertificate(@RequestBody Certificate certificate) {
        return repository.save(certificate);
    }

    @GetMapping("/birth/{birthRegistrationId}")
    public Certificate getCertificateByBirthRegistrationId(
            @PathVariable Long birthRegistrationId
    ) {
        return repository.findByBirthRegistrationId(birthRegistrationId);
    }
}