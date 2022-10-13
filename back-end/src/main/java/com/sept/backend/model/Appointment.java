package com.sept.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
@Embeddable
public class Appointment {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "doctorId")
    private long doctorId;

    private String doctorName;

    @Column(name = "patientId")
    private long patientId;

    private String startTime;

    private String endTime;

    public Appointment() {

    }

    public Appointment(long doctorId, long patientId, String startTime, String endTime) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}