package com.example.cliniconlinebackend.controllers;


import com.example.cliniconlinebackend.entities.Clinic;
import com.example.cliniconlinebackend.entities.Doctor;
import com.example.cliniconlinebackend.repositories.ClinicRepository;
import com.example.cliniconlinebackend.repositories.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClinicController {

    @Autowired
    ClinicRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/clinics",method = RequestMethod.GET)
    public List<Clinic> getAllClinics(){
        List<Clinic> all = repository.findAll();
        List<Clinic> novi =  new ArrayList<>();
        for(int i =0; i< all.size(); i++ ){
            if(all.get(i).getObrisana() == 0) novi.add(all.get(i));
        }
        return novi;
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


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/updateObrisanaKlinika",method = RequestMethod.POST)
    public Clinic updateObrisan(@RequestBody Clinic c){
        int rez = repository.updateObrisana(c.getId_clinic());
        return c;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/registruj",method = RequestMethod.POST)
    public Clinic registrujKliniku(@RequestBody Clinic c){
        this.repository.save(c);
        return c;
    }
}
