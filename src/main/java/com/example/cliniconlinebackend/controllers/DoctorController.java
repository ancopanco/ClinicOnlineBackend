package com.example.cliniconlinebackend.controllers;

import com.example.cliniconlinebackend.entities.Clinic;
import com.example.cliniconlinebackend.entities.Doctor;
import com.example.cliniconlinebackend.entities.Patient;
import com.example.cliniconlinebackend.repositories.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/registerDoctor",method = RequestMethod.POST)
    public Doctor registerDoctor(@RequestBody DoctorForm doctorForm){
        String username = doctorForm.getUsername();
        String password = doctorForm.getPassword();
        String email = doctorForm.getEmail();
        String firstname = doctorForm.getFirstname();
        String lastname = doctorForm.getLastname();
        String age = doctorForm.getAge();
        String gender = doctorForm.getGender();
        String phone_number = doctorForm.getPhone_number();
        LOGGER.info(username + " " + password + phone_number);
        String user_type = doctorForm.getUser_type();
        String specialization = doctorForm.getSpecialization();
        String biography = doctorForm.getBiography();

        int id_clinic = doctorForm.getId_clinic();

        List<Doctor> doctorBaza = repository.findByUsername(username);
        if(doctorBaza.isEmpty() == false) return null;

        doctorBaza = repository.findByEmail(email);
        if(doctorBaza.isEmpty() == false) return null;



        Doctor doctor = new Doctor();
        doctor.setUsername(username);
        doctor.setPassword(password);
        doctor.setEmail(email);
        doctor.setFirstname(firstname);
        doctor.setLastname(lastname);
        doctor.setAge(age);
        doctor.setGender(gender);
        doctor.setPhone_number(phone_number);
        doctor.setUser_type(user_type);
        doctor.setBiography(biography);
        doctor.setSpecialization(specialization);
        doctor.setAccepted(0);
        doctor.setId_clinic(id_clinic);
        repository.save(doctor);
        return doctor;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getDoctorByUsername",method = RequestMethod.POST)
    public Doctor getDoctorByUsername(@RequestBody String username){
        LOGGER.info(username);
        List<Doctor> allDoctors = repository.findAll();
        LOGGER.info("broj doktora" + allDoctors.size());
        for(int i =0; i< allDoctors.size();i++){
            if(allDoctors.get(i).getUsername().equals(username)) return allDoctors.get(i);
        }
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/doctorById",method = RequestMethod.POST)
    public Doctor getDoctorByUsername(@RequestBody int id){
        List<Doctor> allDoctors = repository.findAll();
        LOGGER.info("broj doktora" + allDoctors.size());
        for(int i =0; i< allDoctors.size();i++){
            if(allDoctors.get(i).getId_doctor()==(id)) return allDoctors.get(i);
        }
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/doctors",method = RequestMethod.GET)
    public List<Doctor> getAllClinics(){
        return repository.findAll();
    }

}
