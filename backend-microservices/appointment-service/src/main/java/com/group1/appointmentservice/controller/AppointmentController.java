package com.group1.appointmentservice.controller;

import com.group1.appointmentservice.model.Appointment;
import com.group1.appointmentservice.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @PostMapping("/appointment/make")
    public ResponseEntity<String> makeAppointment(@RequestBody Appointment appointment) {
        appointmentRepository.save(appointment);
        return ResponseEntity.ok("Appointment created");
    }

    @GetMapping("/appointment/view")
    public ResponseEntity<List<Appointment>> viewAppointment(@RequestParam long patientId) {
        // get all appointments
        List<Appointment> appointments = appointmentRepository.findAll();
        System.out.println("appointment len: " + appointments.size());
        // filter appointment by patientID
        List<Appointment> filteredAppointments = appointments.stream().filter(a -> a.getPatientId() == patientId).collect(Collectors.toList());
        // set doctor name for each appointment
//        filteredAppointments.stream().forEach(a -> {
//            User user = userRepository.findById(a.getDoctorId()).orElse(null);
//            String doctorName = String.format("%s %s", user.getFirstName(), user.getLastName());
//            a.setDoctorName(doctorName);
//        });
        return ResponseEntity.ok(filteredAppointments);
    }
}