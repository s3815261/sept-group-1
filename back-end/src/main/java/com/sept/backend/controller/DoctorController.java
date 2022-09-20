package com.sept.backend.controller;

import com.sept.backend.model.Availability;
import com.sept.backend.model.Doctor;
import com.sept.backend.payload.DoctorSetAvailabilityRequest;
import com.sept.backend.payload.DoctorAddInfoRequest;
import com.sept.backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping("/doctor/register")
    public ResponseEntity<String> registerDoctor(@RequestParam long id) {
        Doctor newDoctor = new Doctor(id);
        doctorRepository.save(newDoctor);
        return ResponseEntity.ok("Doctor registered");
    }

    @PostMapping("/doctor/setinfo")
    public ResponseEntity<String> setInfo(@RequestBody DoctorAddInfoRequest request) {
        Doctor doctorFromDB = doctorRepository.findById(request.getDoctor_id()).orElse(null);
        // Doctor id does not exsit in DB
        if (doctorFromDB == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor Not Found");
        }
        // Set doctor information
        doctorFromDB.setDoctorInfo(request.getDoctor_info());
        doctorRepository.save(doctorFromDB);
        return ResponseEntity.ok("Info added");
    }

    @PostMapping("/doctor/setavailability")
    public ResponseEntity<String> setAvailability(@RequestBody DoctorSetAvailabilityRequest request) {
        Doctor doctorFromDB = doctorRepository.findById(request.getDoctor_id()).orElse(null);
        // Doctor id does not exist in DB
        if (doctorFromDB == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor Not Found");
        }
        // Get availability from the request
        Availability availability = request.getAvailability();
        // Set doctor's availability
        doctorFromDB.setAvailability(availability);
        doctorRepository.save(doctorFromDB);
        return ResponseEntity.ok("Availabilities set");
    }
}