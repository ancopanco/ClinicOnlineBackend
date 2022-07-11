package com.example.cliniconlinebackend.controllers;

import com.example.cliniconlinebackend.entities.Blog;
import com.example.cliniconlinebackend.entities.Doctor;
import com.example.cliniconlinebackend.repositories.BlogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/blogs",method = RequestMethod.GET)
    public List<Blog> getAllBlogs(){
        List<Blog> all =  repository.findAll();
        List<Blog> novi = new ArrayList<>();
        for(int i =0; i< all.size();i++){
            if(all.get(i).getAccepted()==1) {
                novi.add(all.get(i));
            }
        }
        return novi;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/zahteviBlogs",method = RequestMethod.GET)
    public List<Blog> getZahtevi(){
        List<Blog> all =  repository.findAll();
        List<Blog> novi = new ArrayList<>();
        for(int i =0; i< all.size();i++){
            if(all.get(i).getAccepted()==0) {
                novi.add(all.get(i));
            }
        }
        return novi;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/saveBlog",method = RequestMethod.POST)
    public Blog saveBlog(@RequestBody Blog b){
        repository.save(b);
        return b;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/deleteBlog",method = RequestMethod.POST)
    public Doctor deleteBlog(@RequestBody int id){
        repository.deleteById(id);
        return null;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/updateBlog",method = RequestMethod.POST)
    public Blog updateBlog(@RequestBody Blog b){
        int rez = repository.updateBlog(b.getId_blog());
        return b;
    }

}
