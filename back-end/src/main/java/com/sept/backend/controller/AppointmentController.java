package com.sept.backend.controller;

import com.sept.backend.model.Appointment;
import com.sept.backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @PostMapping("/appointment/make")
    public ResponseEntity<String> makeAppointment(@RequestBody Appointment appointment) {
        appointmentRepository.save(appointment);
        return ResponseEntity.ok("Appointment created");
    }
}