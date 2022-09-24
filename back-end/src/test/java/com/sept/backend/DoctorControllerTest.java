package com.sept.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sept.backend.controller.DoctorController;
import com.sept.backend.model.Availability;
import com.sept.backend.model.Doctor;
import com.sept.backend.repository.DoctorRepository;
import com.sept.backend.repository.UserRepository;
import com.sept.backend.service.CustomUserDetailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@WebMvcTest(DoctorController.class)
public class DoctorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorRepository doctorRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private CustomUserDetailService customUserDetailService;

    private ObjectMapper objectMapper = new ObjectMapper();

    static final long mockID = 45;
    private Doctor doctor;

    @BeforeEach
    void setup() {

//        System.out.println("DONE SETING UP");
//        Doctor doctorFromDB = doctorRepository.findById(mockID).orElse(null);
//        System.out.println(doctorFromDB.getId());
//        System.out.println(doctorFromDB.getAvailability());
    }

    @Test
    public void testRegisterDoctor() throws Exception {
        mockMvc.perform(post("/doctor/register").param("id", String.valueOf(20))).andExpect(status().isOk());
    }

    @Test
    public void testRegisterDoctorError() throws Exception {
        mockMvc.perform(post("/doctor/register").param("idea", String.valueOf(20))).andExpect(status().isBadRequest());
    }

    @Test
    public void testSetDoctorInfo() throws Exception {
        Map<String, Object> body = new HashMap<>();
        body.put("doctor_id", mockID);
        body.put("doctor_info", "PHD in orthopedic");
        mockMvc.perform(post("/doctor/setinfo").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body)))
                .andExpect(status().isOk());
    }

    @Test
    public void testSetDoctorAvailability() throws Exception {
        Map<String, Object> availabilities = new HashMap<>();
        availabilities.put("monday", "1663501568:1663601568");
        availabilities.put("tuesday", "1663501568:1663601568");
        availabilities.put("wednesday", "1663501568:1663601568");
        Map<String, Object> body = new HashMap<>();
        body.put("doctor_id", mockID);
        body.put("availability", availabilities);
        mockMvc.perform(post("/doctor/setavailability").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetDoctorAvailability() throws Exception {
        Availability availability = new Availability("1663501568:1663601568", null, null, null, null);
        doctor = new Doctor(mockID);
        doctor.setAvailability(availability);
        Mockito.when(doctorRepository.findById(mockID)).thenReturn(Optional.ofNullable(doctor));
        String id = String.valueOf(mockID);
        mockMvc.perform(get("/doctor/getavailability").param("id", id)).andExpect(status().isOk());
    }
}