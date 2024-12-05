package com.yassine.films.restcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.yassine.films.entities.User;
import com.yassine.films.service.JWTService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authManager; 

    @Autowired
    private com.yassine.films.repos.UserRepository userRepository; 
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User loginRequest) {
        Map<String, Object> response = new HashMap<>();

        try {
      
            Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());

 if (optionalUser.isPresent()) {
    User foundUser = optionalUser.get();
      if (encoder.matches(loginRequest.getPassword(), foundUser.getPassword())) {
       Authentication authentication = authManager.authenticate(
   new UsernamePasswordAuthenticationToken(foundUser.getEmail(), loginRequest.getPassword() ));

     String token = jwtService.generateToken((UserDetails) authentication.getPrincipal());
      response.put("status", "success");
    response.put("message", "Login successful");
    response.put("user",foundUser); 
            response.put("token", token);  
            return ResponseEntity.ok(response);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid mot de passe");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during authentication: " + e.getMessage());
        }
    }

   
    @PostMapping("/register")
    public ResponseEntity<?> signupUser(@RequestBody User newUser) {
        try {

            Optional<User> existingUser = userRepository.findByEmail(newUser.getEmail());

            if (existingUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email est exist deja");
            }

      
            newUser.setPassword(encoder.encode(newUser.getPassword()));

        
            User savedUser = userRepository.save(newUser);

            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed: " + e.getMessage());
        }
    }
}