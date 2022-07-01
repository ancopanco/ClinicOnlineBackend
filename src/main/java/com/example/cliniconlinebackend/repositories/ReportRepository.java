package com.example.cliniconlinebackend.repositories;


import com.example.cliniconlinebackend.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer> {

}
