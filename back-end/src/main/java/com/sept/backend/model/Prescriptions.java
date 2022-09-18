package com.sept.backend.model;

public class Prescriptions {
    private Integer id;
    private Integer doctorId;
    private Integer patientId;
    private String drug;
    private String symptom;

    public Prescriptions() {

    }

    public Prescriptions(Integer id, Integer doctorId, Integer patientId, String drug, String symptom) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.drug = drug;
        this.symptom = symptom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
