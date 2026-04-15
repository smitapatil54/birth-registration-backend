package com.example.birthregistrationbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long birthRegistrationId;

    private String motherAadhar;
    private String fatherAadhar;
    private String birthSlip;
    private String addressProof;
    private String marriageCertificate;

    public Long getId() {
        return id;
    }

    public Long getBirthRegistrationId() {
        return birthRegistrationId;
    }

    public void setBirthRegistrationId(Long birthRegistrationId) {
        this.birthRegistrationId = birthRegistrationId;
    }

    public String getMotherAadhar() {
        return motherAadhar;
    }

    public void setMotherAadhar(String motherAadhar) {
        this.motherAadhar = motherAadhar;
    }

    public String getFatherAadhar() {
        return fatherAadhar;
    }

    public void setFatherAadhar(String fatherAadhar) {
        this.fatherAadhar = fatherAadhar;
    }

    public String getBirthSlip() {
        return birthSlip;
    }

    public void setBirthSlip(String birthSlip) {
        this.birthSlip = birthSlip;
    }

    public String getAddressProof() {
        return addressProof;
    }

    public void setAddressProof(String addressProof) {
        this.addressProof = addressProof;
    }

    public String getMarriageCertificate() {
        return marriageCertificate;
    }

    public void setMarriageCertificate(String marriageCertificate) {
        this.marriageCertificate = marriageCertificate;
    }
}