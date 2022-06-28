package com.example.cliniconlinebackend.controllers;

import com.example.cliniconlinebackend.entities.Patient;
import com.example.cliniconlinebackend.entities.User;
import com.example.cliniconlinebackend.repositories.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/registerPatient",method = RequestMethod.POST)
    public Patient registerUser(@RequestBody PatientForm patientForm){
        LOGGER.info(patientForm.toString());
        String username = patientForm.getUsername();
        String password = patientForm.getPassword();
        String email = patientForm.getEmail();
        String firstname = patientForm.getFirstname();
        String lastname = patientForm.getLastname();
        String age = patientForm.getAge();
        String gender = patientForm.getGender();
        String phone_number = patientForm.getPhone_number();
        String user_type = patientForm.getUser_type();

        List<Patient> patientBaza = repository.findByUsername(username);
        if(patientBaza.isEmpty() == false) return null;

        patientBaza = repository.findByEmail(email);
        if(patientBaza.isEmpty() == false) return null;

        Patient patient = new Patient();
        patient.setUsername(username);
        patient.setPassword(password);
        patient.setEmail(email);
        patient.setFirstname(firstname);
        patient.setLastname(lastname);
        patient.setAge(age);
        patient.setGender(gender);
        patient.setPhone_number(phone_number);
        patient.setUser_type(user_type);
        patient.setUser_id_user(1);
        repository.save(patient);
        return patient;
    }
}
