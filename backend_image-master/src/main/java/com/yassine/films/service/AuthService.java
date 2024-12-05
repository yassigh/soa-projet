package com.yassine.films.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yassine.films.entities.User;
import com.yassine.films.repos.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

 
    public String registerUser(User user) {
        try {
           
            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
                throw new RuntimeException("L'email est deja utilise.");
            }

            if (userRepository.findByUsername(user.getUsername()).isPresent()) {
                throw new RuntimeException("Le nom d'utilisateur est deea utilise.");
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(user);
            return "Utilisateur enregistré avec succès";
        } catch (Exception e) {
            throw new RuntimeException("Erreur d'enregistrement: " + e.getMessage(), e);
        }
    }

   
    public User login(String username, String password) {
        try {
            // Authentifier l'utilisateur via l'AuthenticationManager
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

       
            return userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé après authentification."));
        } catch (Exception e) {
            throw new RuntimeException("Nom d'utilisateur ou mot de passe invalide", e);
        }
    }
}
