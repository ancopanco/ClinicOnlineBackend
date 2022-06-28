package com.example.cliniconlinebackend.controllers;


import com.example.cliniconlinebackend.entities.Clinic;
import com.example.cliniconlinebackend.repositories.ClinicRepository;
import com.example.cliniconlinebackend.repositories.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClinicController {

    @Autowired
    ClinicRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/clinics",method = RequestMethod.GET)
    public List<Clinic> getAllClinics(){
        return repository.findAll();
    }
}
