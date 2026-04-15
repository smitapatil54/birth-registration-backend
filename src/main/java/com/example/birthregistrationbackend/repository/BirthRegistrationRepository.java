package com.example.birthregistrationbackend.repository;

import com.example.birthregistrationbackend.entity.BirthRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BirthRegistrationRepository
        extends JpaRepository<BirthRegistration, Long> {

    BirthRegistration findTopByUserIdOrderByIdDesc(Long userId);

    List<BirthRegistration> findByStatus(String status);
}