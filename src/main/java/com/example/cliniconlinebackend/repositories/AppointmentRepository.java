package com.example.cliniconlinebackend.repositories;

import com.example.cliniconlinebackend.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    @Transactional
    @Modifying
    @Query("update Appointment a set a.canceled = ?2 where a.id_appointment = ?1 ")
    int cancelAppointment(int id_appointment, int canceled);
}
