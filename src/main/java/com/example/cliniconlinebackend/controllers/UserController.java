package com.example.cliniconlinebackend.controllers;

import com.example.cliniconlinebackend.entities.Patient;
import com.example.cliniconlinebackend.entities.User;
import com.example.cliniconlinebackend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getUsers(){
        LOGGER.info("Finding all users.");
        return repository.findAll();
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public User getProductById( @PathVariable("id") int id){
        LOGGER.info("Finding product by id "+ id);
        return repository.findById(id).get();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User login( @RequestBody  LoginForm loginForm){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        LOGGER.info(username + password);
        List<User> users = repository.findAll();
        User user = new User();
        for(int i =0; i< users.size();i++){
            if(username.equals(users.get(i).getUsername()) ){
                LOGGER.info("Postoji username");
                if(password.equals(users.get(i).getPassword())){
                    LOGGER.info("Postoji password");
                    user = users.get(i);
                    return user;
                }
            }
        }
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public User registerUser( @RequestBody PatientForm patientForm){
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
//        LOGGER.info(username + password);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUser_type(user_type);
        LOGGER.info(username + " " + password);

        repository.save(user);
        return user;
//        Patient patient = new Patient();
//        patient.setUsername(username);
//        patient.setPassword(password);
//        patient.setEmail(email);
//        patient.setFirstname(firstname);
//        patient.setLastname(lastname);
//        patient.setAge(age);
//        patient.setGender(gender);
//        patient.setPhone_number(phone_number);
//        patient.setUser_type(user_type);
    }
}
