package com.example.cliniconlinebackend.controllers;

import com.example.cliniconlinebackend.entities.Appointment;
import com.example.cliniconlinebackend.repositories.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentRepository repository;


    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/appointments",method = RequestMethod.GET)
    public List<Appointment> getAllAppointments(){
        List<Appointment> all =  repository.findAll();
        List<Appointment> novi = new ArrayList<>();
        for(int i = 0; i< all.size(); i++){
            if(all.get(i).getCanceled() == 0) novi.add(all.get(i));
        }
        return novi;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/appointmentsByDoctor/{id_doctor}",method = RequestMethod.GET)
    public List<Appointment> getAppointmentsByDoctor(@PathVariable("id_doctor") int id_doctor){
        List<Appointment> all =  repository.findAll();
        List<Appointment> forDoc = new ArrayList<>();
        for(int i =0; i< all.size();i++){

            if(all.get(i).getId_doctor() == id_doctor) {
                forDoc.add(all.get(i));
            }
        }
        return forDoc;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/saveAppointment",method = RequestMethod.POST)
    public Appointment saveAppointment(@RequestBody Appointment a){
        repository.save(a);
        return a;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/cancelAppointment/{id_appointment}",method = RequestMethod.GET)
    public Appointment cancelAppointment(@PathVariable("id_appointment") int id_appointment){
        this.repository.cancelAppointment(id_appointment,1);
        Appointment a = new Appointment();
        return  a;
    }
}
