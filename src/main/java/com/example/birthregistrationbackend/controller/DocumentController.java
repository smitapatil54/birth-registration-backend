package com.example.birthregistrationbackend.controller;

import com.example.birthregistrationbackend.entity.BirthRegistration;
import com.example.birthregistrationbackend.entity.Document;
import com.example.birthregistrationbackend.repository.BirthRegistrationRepository;
import com.example.birthregistrationbackend.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/document")
@CrossOrigin("*")
public class DocumentController {

    @Autowired
    private DocumentRepository repository;

    @Autowired
    private BirthRegistrationRepository birthRepository;

    private final String uploadDir =
            System.getProperty("user.dir") + File.separator + "uploads" + File.separator;

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Document saveDocument(
            @RequestParam("birthRegistrationId") Long birthRegistrationId,
            @RequestParam(value = "motherAadhar", required = false) MultipartFile motherAadhar,
            @RequestParam(value = "fatherAadhar", required = false) MultipartFile fatherAadhar,
            @RequestParam(value = "birthSlip", required = false) MultipartFile birthSlip,
            @RequestParam(value = "addressProof", required = false) MultipartFile addressProof,
            @RequestParam(value = "marriageCertificate", required = false) MultipartFile marriageCertificate
    ) throws IOException {

        File folder = new File(uploadDir);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        Document document = new Document();
        document.setBirthRegistrationId(birthRegistrationId);

        BirthRegistration registration =
                birthRepository.findById(birthRegistrationId).orElse(null);

        if (registration == null) {
            return null;
        }

        if (motherAadhar != null && !motherAadhar.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + motherAadhar.getOriginalFilename();
            motherAadhar.transferTo(new File(uploadDir + fileName));

            document.setMotherAadhar(fileName);
            registration.setMotherAadhar(fileName);
        }

        if (fatherAadhar != null && !fatherAadhar.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + fatherAadhar.getOriginalFilename();
            fatherAadhar.transferTo(new File(uploadDir + fileName));

            document.setFatherAadhar(fileName);
            registration.setFatherAadhar(fileName);
        }

        if (birthSlip != null && !birthSlip.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + birthSlip.getOriginalFilename();
            birthSlip.transferTo(new File(uploadDir + fileName));

            document.setBirthSlip(fileName);
            registration.setBirthSlip(fileName);
        }

        if (addressProof != null && !addressProof.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + addressProof.getOriginalFilename();
            addressProof.transferTo(new File(uploadDir + fileName));

            document.setAddressProof(fileName);
            registration.setAddressProof(fileName);
        }

        if (marriageCertificate != null && !marriageCertificate.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + marriageCertificate.getOriginalFilename();
            marriageCertificate.transferTo(new File(uploadDir + fileName));

            document.setMarriageCertificate(fileName);
            registration.setMarriageCertificate(fileName);
        }

        birthRepository.save(registration);

        return repository.save(document);
    }
}