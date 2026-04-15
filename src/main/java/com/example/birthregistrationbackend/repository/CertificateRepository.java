package com.example.birthregistrationbackend.repository;

import com.example.birthregistrationbackend.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    Certificate findByBirthRegistrationId(Long birthRegistrationId);
}