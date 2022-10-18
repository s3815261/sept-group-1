package com.group1.doctorservice.model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class)
})
public class Doctor {
    @Id
    private long doctor_id;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Availability availability;

    private String doctorInfo;

    public Doctor() {
    }

    public Doctor(long doctor_id) {
        this.doctor_id = doctor_id;
        this.availability= null;
        this.doctorInfo = "";
    }

    public long getId() {
        return this.doctor_id;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Availability getAvailability() {
        return this.availability;
    }

    public String getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(String doctorInfo) {
        this.doctorInfo = doctorInfo;
    }
}


