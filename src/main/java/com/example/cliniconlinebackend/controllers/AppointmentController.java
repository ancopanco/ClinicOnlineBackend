package com.example.cliniconlinebackend.controllers;

import com.example.cliniconlinebackend.entities.Appointment;
import com.example.cliniconlinebackend.repositories.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentRepository repository;


    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/appointments",method = RequestMethod.GET)
    public List<Appointment> getAllBlogs(){
        List<Appointment> all =  repository.findAll();
//        for(int i =0; i< all.size();i++){
//            if(all.get(i).getCanceled()==0) all.remove(all.get(i));
//        }
        return all;
    }
}
