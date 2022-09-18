package com.sept.backend.controller;

import com.sept.backend.model.Doctor;
import com.sept.backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping("/doctor/register")
    public String registerDoctor(@RequestParam long id) {
        Doctor newDoctor = new Doctor(id);
        doctorRepository.save(newDoctor);
        return "SUCCESS";
    }
}