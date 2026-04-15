package com.example.birthregistrationbackend.repository;

import com.example.birthregistrationbackend.entity.HospitalVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalVerificationRepository extends JpaRepository<HospitalVerification, Long> {
}