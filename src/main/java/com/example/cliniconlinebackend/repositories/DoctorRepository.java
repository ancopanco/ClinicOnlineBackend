package com.example.cliniconlinebackend.repositories;

import com.example.cliniconlinebackend.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    List<Doctor> findByUsername(String username);
    List<Doctor> findByEmail(String email);
}
