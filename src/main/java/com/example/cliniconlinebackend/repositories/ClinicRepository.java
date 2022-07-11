package com.example.cliniconlinebackend.repositories;

import com.example.cliniconlinebackend.entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    @Transactional
    @Modifying
    @Query("update Clinic d set d.obrisana = 1 where d.id_clinic = ?1")
    int updateObrisana(int id_clinic);
}
