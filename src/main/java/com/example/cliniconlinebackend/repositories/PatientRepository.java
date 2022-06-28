package com.example.cliniconlinebackend.repositories;

import com.example.cliniconlinebackend.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository  extends JpaRepository<Patient,Integer> {
    List<Patient> findByUsername(String username);
    List<Patient> findByEmail(String email);
}
