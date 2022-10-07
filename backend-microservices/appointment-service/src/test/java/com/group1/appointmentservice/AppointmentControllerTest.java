package com.group1.appointmentservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.group1.appointmentservice.controller.AppointmentController;
import com.group1.appointmentservice.model.Appointment;
import com.group1.appointmentservice.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@WebMvcTest(AppointmentController.class)
public class AppointmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AppointmentRepository appointmentRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    static final long mockPatientID = 35;

    @Test
    public void testMakeAppointment() throws Exception {
        Appointment appointment = new Appointment(34, 35, "1664940931", "1664943000");
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(appointment);
        mockMvc.perform(post("/appointment/make")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON))
                .andExpect(status().isOk());
    }

//    @Test
//    public void testViewAppointment() throws Exception {
//        // populate the first appointment
//        long mockDoctorId1 = 30;
//        Appointment appointment1 = new Appointment(mockDoctorId1, mockPatientID, "1664940931", "1664943000");
//        User user1 = new User("Raj", "Singh", "rsingh@mail.com", "password456", "doctor", false);
//        Mockito.when(userRepository.findById(mockDoctorId1)).thenReturn(Optional.of(user1));
//
//        // populate the second appointment
//        long mockDoctorId2 = 31;
//        Appointment appointment2 = new Appointment(31, mockPatientID, "1664943931", "1664944000");
//        User user2 = new User("Tim", "Ark", "tark@mail.com", "password789", "doctor", false);
//        Mockito.when(userRepository.findById(mockDoctorId2)).thenReturn(Optional.of(user2));
//
//        Mockito.when(appointmentRepository.findAll()).thenReturn(List.of(appointment1, appointment2));
//        String id = String.valueOf(mockPatientID);
//        mockMvc.perform(get("/appointment/view").param("patientId", id)).andExpect(status().isOk());
//    }
}
