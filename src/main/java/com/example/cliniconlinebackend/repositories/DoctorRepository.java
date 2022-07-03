package com.example.cliniconlinebackend.repositories;

import com.example.cliniconlinebackend.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    List<Doctor> findByUsername(String username);
    List<Doctor> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update Doctor p set p.age = ?1, p.gender = ?2, p.phone_number = ?3, p.password = ?4,  p.firstname = ?5,  p.lastname = ?6,  p.email = ?7, p.specialization = ?8, p.biography = ?9, p.accepted = ?10, p.id_clinic = ?11 where p.id_doctor = ?12 ")
    int updateDoctor(String age, String gender, String phone_number, String password, String firstname, String lastname, String email, String specialization, String biography, int accepted, int id_clinic, int id_doctor);
}
