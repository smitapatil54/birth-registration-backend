package com.example.birthregistrationbackend.repository;

import com.example.birthregistrationbackend.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    Document findByBirthRegistrationId(Long birthRegistrationId);
}