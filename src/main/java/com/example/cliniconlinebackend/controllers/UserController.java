package com.example.cliniconlinebackend.controllers;

import com.example.cliniconlinebackend.entities.User;
import com.example.cliniconlinebackend.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
