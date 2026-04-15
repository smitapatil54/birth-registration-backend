// File: src/main/java/com/example/birthregistrationbackend/entity/BirthRegistration.java

package com.example.birthregistrationbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BirthRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String applicationId;

    private String childName;
    private String gender;
    private String birthDate;
    private String birthTime;
    private String hospitalName;
    private String fatherName;
    private String motherName;
    private String address;

    private String motherAadhar;
    private String fatherAadhar;
    private String birthSlip;
    private String addressProof;
    private String marriageCertificate;

    private String status = "Pending Hospital Verification";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}