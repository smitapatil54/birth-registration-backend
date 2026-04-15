package com.example.birthregistrationbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BmcVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicationId;
    private String action;
    private String remarks;
}