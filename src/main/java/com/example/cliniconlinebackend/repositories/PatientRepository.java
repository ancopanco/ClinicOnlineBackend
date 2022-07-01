package com.example.cliniconlinebackend.repositories;

import com.example.cliniconlinebackend.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PatientRepository  extends JpaRepository<Patient,Integer> {
    List<Patient> findByUsername(String username);
    List<Patient> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update Patient p set p.age = ?1, p.gender = ?2, p.phone_number = ?3, p.password = ?4,  p.firstname = ?5,  p.lastname = ?6,  p.email = ?7 where p.id_patient = ?8  ")
    int updateUser(String age, String gender, String phone_number, String password, String firstname, String lastname, String email, int id_patient);
}
