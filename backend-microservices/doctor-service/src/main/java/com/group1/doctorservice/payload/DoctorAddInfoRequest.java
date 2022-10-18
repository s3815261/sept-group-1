package com.group1.doctorservice.payload;

public class DoctorAddInfoRequest {
    private long doctor_id;

    private String doctor_info;

    public DoctorAddInfoRequest(long doctor_id, String doctor_info) {
        this.doctor_id = doctor_id;
        this.doctor_info = doctor_info;
    }

    public long getDoctor_id() {
        return this.doctor_id;
    }

    public String getDoctor_info() {
        return this.doctor_info;
    }
}
