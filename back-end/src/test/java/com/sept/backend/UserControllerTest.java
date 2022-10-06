package com.sept.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sept.backend.controller.UserController;
import com.sept.backend.model.User;
import com.sept.backend.payload.UserLoginRequest;
import com.sept.backend.payload.UserUpdateStatusRequest;
import com.sept.backend.repository.DoctorRepository;
import com.sept.backend.repository.UserRepository;
import com.sept.backend.service.CustomUserDetailService;
import com.sept.backend.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorRepository doctorRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private CustomUserDetailService customUserDetailService;

    private ObjectMapper objectMapper = new ObjectMapper();

    static final long mockID = 20;

    private User user;

    @Test
    public void testLoginUser() throws Exception {
        UserLoginRequest request = new UserLoginRequest("sqleo@mail.com", "p12345");
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(request);
        mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testRegisterUser() throws Exception {
        User newUser = new User("sq", "leo", "sqleo@mail.com", "p12345", "patient", false);
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(newUser);
        mockMvc.perform(post("/users/register").contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testLogoutUser() throws Exception {
        User newUser = new User("sq", "leo", "sqleo@mail.com", "p12345", "patient", false);
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(newUser);
        mockMvc.perform(post("/users/logout").contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateStatus() throws Exception {
        user = new User(mockID);
        Mockito.when(userRepository.findById(mockID)).thenReturn(Optional.of(user));
        UserUpdateStatusRequest request = new UserUpdateStatusRequest(mockID, "Having a fever");
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJSON = ow.writeValueAsString(request);
        mockMvc.perform(post("/users/updatestatus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJSON))
                .andExpect(status().isOk());
    }
}