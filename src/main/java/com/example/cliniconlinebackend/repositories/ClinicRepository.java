package com.example.cliniconlinebackend.repositories;

import com.example.cliniconlinebackend.entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
}
