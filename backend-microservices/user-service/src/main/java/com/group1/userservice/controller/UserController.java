package com.group1.userservice.controller;

import com.group1.userservice.model.User;
import com.group1.userservice.model.Users;
import com.group1.userservice.payload.UserLoginRequest;
import com.group1.userservice.payload.UserUpdateStatusRequest;
import com.group1.userservice.repository.UserRepository;
import com.group1.userservice.service.CustomUserDetailService;
import com.group1.userservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService userDetailService;

    protected RestTemplate restTemplate = new RestTemplate();

    private Users users;

    // authenticate user
    private void authenticate(String email, String password) throws Exception {
        try {
            UserDetails userDetails = userDetailService.loadUserByUsername(email);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password);
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping("/users/login")
    public ResponseEntity<?> loginUserWithJWT(@RequestBody UserLoginRequest userLoginRequest) throws Exception {
        // authenticate user
        authenticate(userLoginRequest.getEmail(), userLoginRequest.getPassword());
        final UserDetails userDetails = userDetailService.loadUserByUsername(userLoginRequest.getEmail());
        // generate token
        final String token = jwtUtil.generateToken(userLoginRequest.getEmail());
        // return jwt token
        Map<String,Object> jwtResponse = new HashMap<>();
        jwtResponse.put("token", token);
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/users/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User newUser) throws Exception {
        // search for existing
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equals(newUser.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Email has already been used");
            }
        }
        // encrypt password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        userRepository.save(newUser);
        // make a request to register if user is a doctor
//        if (newUser.getRole().equals("doctor")) {
//            String serviceUrl = String.format("http://localhost:8080/doctor/register?id=%d", newUser.getId());
//            URL url = new URL(serviceUrl);
//            ResponseEntity<String> response = restTemplate.postForEntity(url.toURI(), null, String.class);
//        }
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/users/logout")
    public ResponseEntity<String> logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                userRepository.save(user);
                return ResponseEntity.ok("Success");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: non-existing user");
    }

    @PostMapping("/users/updatestatus")
    public ResponseEntity<String> updateStatus(@RequestBody UserUpdateStatusRequest request) {
        // Get user from DB
        User userFromDB = userRepository.findById(request.getUser_id()).orElse(null);
        // User id does not exist in DB
        if (userFromDB == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        }
        // User exist
        userFromDB.setHealthStatus(request.getStatus());
        // Save status in DB
        userRepository.save(userFromDB);
        return ResponseEntity.ok("Status updated");
    }

}
