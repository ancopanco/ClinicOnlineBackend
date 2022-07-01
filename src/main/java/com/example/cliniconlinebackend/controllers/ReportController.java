package com.example.cliniconlinebackend.controllers;

import com.example.cliniconlinebackend.entities.Patient;
import com.example.cliniconlinebackend.entities.Report;
import com.example.cliniconlinebackend.repositories.ReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReportController {

    @Autowired
    ReportRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/reportByIdPatient/{id_patient}",method = RequestMethod.GET)
    public List<Report> getReportByIdPatient(@PathVariable int id_patient){
        LOGGER.info(id_patient +"");
        List<Report> all = repository.findAll();
        List<Report> forPat = new ArrayList<>();
        for(int i = 0; i< all.size(); i++){
            if(all.get(i).getId_patient() == id_patient) forPat.add(all.get(i));
        }
        return forPat;
    }
}
