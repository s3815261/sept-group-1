package com.sept.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sept.backend.controller.AppointmentController;
import com.sept.backend.model.Appointment;
import com.sept.backend.repository.AppointmentRepository;
import com.sept.backend.repository.UserRepository;
import com.sept.backend.service.CustomUserDetailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@WebMvcTest(AppointmentController.class)
public class AppointmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private AppointmentRepository appointmentRepository;

    @MockBean
    private CustomUserDetailService customUserDetailService;

    private ObjectMapper objectMapper = new ObjectMapper();

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
}
