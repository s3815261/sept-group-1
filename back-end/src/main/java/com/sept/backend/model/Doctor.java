package com.sept.backend.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "doctor")
//@PrimaryKeyJoinColumn(name = "id")
public class Doctor {
    @Id
    private long doctor_id;
    private ArrayList<Timeslot> availabilities;

    private String doctorInfo;

    public Doctor() {

    }

    public Doctor(long doctor_id) {
        this.doctor_id = doctor_id;
        this.availabilities = new ArrayList<Timeslot>();
        this.doctorInfo = "";
    }

    public long getId() {
        return this.doctor_id;
    }

//    public Doctor(String firstName, String lastName, String email, String password, String role, boolean isAdmin) {
//        super(firstName, lastName, email, password, role, isAdmin);
//        this.availabilities = new ArrayList<String>();
//        this.doctorInfo = "";
//    }

    public void addAvailabilities(Timeslot timeslot) {
        availabilities.add(timeslot);
    }

    public String getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(String doctorInfo) {
        this.doctorInfo = doctorInfo;
    }
}


