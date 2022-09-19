package com.sept.backend.payload;

import com.sept.backend.model.Availability;

public class DoctorSetAvailabilityRequest {
    private long doctor_id;

    private Availability availability;

    public DoctorSetAvailabilityRequest(long doctor_id, Availability availability) {
        this.doctor_id = doctor_id;
        this.availability = availability;
    }

    public long getDoctor_id() {
        return this.doctor_id;
    }

    public Availability getAvailability() {
        return this.availability;
    }
}
