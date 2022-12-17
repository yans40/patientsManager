package com.example.patientmanager.repositories;

import com.example.patientmanager.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long > {
    Page<Patient> findByNomContains(String kw, Pageable pageable);
}
