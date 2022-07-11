package com.example.cliniconlinebackend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_blog;

    private String title;
    private String text;
    private int id_doctor;
    private int accepted;
    private String doctor_firstname;
    private String doctor_lastname;

    public Blog(int id_blog, String title, String text, int id_doctor, int accepted,String doctor_firstname, String doctor_lastname) {
        this.id_blog = id_blog;
        this.title = title;
        this.text = text;
        this.id_doctor = id_doctor;
        this.accepted = accepted;
        this.doctor_firstname =doctor_firstname;
        this.doctor_lastname = doctor_lastname;
    }
    public Blog(){}

    public int getId_blog() {
        return id_blog;
    }

    public void setId_blog(int id_blog) {
        this.id_blog = id_blog;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    public String getDoctor_firstname() {
        return doctor_firstname;
    }

    public void setDoctor_firstname(String doctor_firstname) {
        this.doctor_firstname = doctor_firstname;
    }

    public String getDoctor_lastname() {
        return doctor_lastname;
    }

    public void setDoctor_lastname(String doctor_lastname) {
        this.doctor_lastname = doctor_lastname;
    }
}
