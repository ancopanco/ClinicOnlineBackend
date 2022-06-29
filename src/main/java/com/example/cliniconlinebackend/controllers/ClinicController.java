package com.example.cliniconlinebackend.controllers;


import com.example.cliniconlinebackend.entities.Clinic;
import com.example.cliniconlinebackend.repositories.ClinicRepository;
import com.example.cliniconlinebackend.repositories.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/clinicById/{id}",method = RequestMethod.GET)
    public Clinic getClinicById(@PathVariable("id") int id){
        List<Clinic> allClinic = repository.findAll();
        for(int i = 0; i< allClinic.size();i++){
            if(allClinic.get(i).getId_clinic() ==id ) return allClinic.get(i);
        }
        return null;
    }
}
