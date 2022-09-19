package com.sept.backend.controller;

import com.sept.backend.exception.Status;
import com.sept.backend.model.AuthRequest;
import com.sept.backend.model.User;
import com.sept.backend.model.Users;
import com.sept.backend.payload.UserUpdateStatusRequest;
import com.sept.backend.repository.UserRepository;
import com.sept.backend.service.CustomUserDetailService;
import com.sept.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.print.Doc;
import javax.validation.Valid;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
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
    public ResponseEntity<?> loginUserWithJWT(@RequestBody AuthRequest authRequest) throws Exception {
        // authenticate user
        authenticate(authRequest.getEmail(), authRequest.getPassword());
        final UserDetails userDetails = userDetailService.loadUserByUsername(authRequest.getEmail());
        // generate token
        final String token = jwtUtil.generateToken(authRequest.getEmail());
        // return jwt token
        Map<String,Object> jwtResponse = new HashMap<>();
        jwtResponse.put("token", token);
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody User newUser) throws Exception {
        List<User> users = userRepository.findAll();
        System.out.println("New user: " + newUser.toString());

        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());

            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        // encrypt password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        userRepository.save(newUser);
        // make a request to register if user is a doctor
        if (newUser.getRole().equals("doctor")) {
            String serviceUrl = String.format("http://localhost:8080/doctor/register?id=%d", newUser.getId());
            URL url = new URL(serviceUrl);
            ResponseEntity<String> response = restTemplate.postForEntity(url.toURI(), null, String.class);
        }
        return Status.SUCCESS;
    }

    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
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
