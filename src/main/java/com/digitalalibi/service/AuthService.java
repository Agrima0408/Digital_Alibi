
package com.digitalalibi.service;

import com.digitalalibi.dto.RegisterRequest;
import com.digitalalibi.entity.User;
import com.digitalalibi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest request) {

        System.out.println("REGISTER METHOD CALLED");

        // 1. Check whether the email is already registered
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // 2. Create a new User object
        User user = new User();

        // 3. Copy registration details
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // 4. Hash the password before saving
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        // 5. Save user in PostgreSQL
        userRepository.save(user);

        return "User registered successfully";
    }
}
