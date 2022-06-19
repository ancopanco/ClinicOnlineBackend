package com.example.cliniconlinebackend.repositories;

import com.example.cliniconlinebackend.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient,Integer> {
}
