package com.example.cliniconlinebackend.repositories;

import com.example.cliniconlinebackend.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
