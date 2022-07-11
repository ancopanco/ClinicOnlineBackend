package com.example.cliniconlinebackend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_doctor;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String age;
    private String gender;
    private String phone_number;
    private String user_type;
    private String specialization;
    private String biography;
    private int accepted;
    private int id_clinic;
    private String clinic_name;
    private int obrisan;

    public int getId_clinic() {
        return id_clinic;
    }

    public void setId_clinic(int id_clinic) {
        this.id_clinic = id_clinic;
    }

    public Doctor(){}
    public Doctor(int id_doctor, String username, String password, String email, String firstname, String lastname, String age, String gender, String phone_number, String user_type, String specialization, String biography, String clinic_name, int obrisan) {
        this.id_doctor = id_doctor;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.phone_number = phone_number;
        this.user_type = user_type;
        this.specialization = specialization;
        this.biography = biography;
        this.clinic_name = clinic_name;
        this.obrisan = obrisan;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }

    public int getObrisan() {
        return obrisan;
    }

    public void setObrisan(int obrisan) {
        this.obrisan = obrisan;
    }
}
