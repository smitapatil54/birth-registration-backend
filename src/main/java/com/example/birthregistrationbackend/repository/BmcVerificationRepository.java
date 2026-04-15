package com.example.birthregistrationbackend.repository;

import com.example.birthregistrationbackend.entity.BmcVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BmcVerificationRepository extends JpaRepository<BmcVerification, Long> {
}