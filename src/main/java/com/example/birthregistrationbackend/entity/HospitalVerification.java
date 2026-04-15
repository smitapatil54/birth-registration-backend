package com.example.birthregistrationbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class HospitalVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long birthRegistrationId;

    private String hospitalEmail;

    private String remarks;

    private String status;
}