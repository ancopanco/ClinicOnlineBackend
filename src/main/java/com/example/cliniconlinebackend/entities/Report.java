package com.example.cliniconlinebackend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_report;

    private int id_patient;
    private int id_doctor;
    private String personal_history;
    private String family_history;
    private String current_disease;
    private String clinical_examination;
    private Date date;

    public Report() {}

    public Report(int id_report, int id_patient, int id_doctor, String personal_history, String family_history, String current_disease, String clinical_examination, Date date) {
        this.id_report = id_report;
        this.id_patient = id_patient;
        this.id_doctor = id_doctor;
        this.personal_history = personal_history;
        this.family_history = family_history;
        this.current_disease = current_disease;
        this.clinical_examination = clinical_examination;
        this.date = date;
    }

    public int getId_report() {
        return id_report;
    }

    public void setId_report(int id_report) {
        this.id_report = id_report;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getPersonal_history() {
        return personal_history;
    }

    public void setPersonal_history(String personal_history) {
        this.personal_history = personal_history;
    }

    public String getFamily_history() {
        return family_history;
    }

    public void setFamily_history(String family_history) {
        this.family_history = family_history;
    }

    public String getCurrent_disease() {
        return current_disease;
    }

    public void setCurrent_disease(String current_disease) {
        this.current_disease = current_disease;
    }

    public String getClinical_examination() {
        return clinical_examination;
    }

    public void setClinical_examination(String clinical_examination) {
        this.clinical_examination = clinical_examination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
