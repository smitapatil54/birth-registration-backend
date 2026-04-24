package com.example.birthregistrationbackend.controller;

import com.example.birthregistrationbackend.entity.BirthRegistration;
import com.example.birthregistrationbackend.entity.Certificate;
import com.example.birthregistrationbackend.repository.BirthRegistrationRepository;
import com.example.birthregistrationbackend.repository.CertificateRepository;
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

    @Autowired
    private CertificateRepository certificateRepository;

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

        // Status update
        application.setStatus("Certificate Generated");

        // Unique certificate number generate
        String certNumber = "CERT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        application.setApplicationId(certNumber);

        // 🔥 BONUS FIX (duplicate prevent + certificate save)
        Certificate existing = certificateRepository.findByBirthRegistrationId(application.getId());

        if (existing == null) {
            Certificate cert = new Certificate();

            cert.setBirthRegistrationId(application.getId());
            cert.setApplicationId(certNumber);
            cert.setRegistrationNumber(certNumber);

            cert.setChildName(application.getChildName());
            cert.setFatherName(application.getFatherName());
            cert.setMotherName(application.getMotherName());
            cert.setBirthDate(application.getBirthDate());
            cert.setHospitalName(application.getHospitalName());

            cert.setIssuedBy("BMC");

            certificateRepository.save(cert);
        }

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