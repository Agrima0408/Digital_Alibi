package com.digitalalibi.config;

import com.digitalalibi.entity.User;
import com.digitalalibi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.admin.email}")
    private String adminEmail;

    @Value("${app.admin.password}")
    private String adminPassword;

    public AdminInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args){
        if (userRepository.findByEmail(adminEmail).isPresent()) {
            User existingUser = userRepository.findByEmail(adminEmail).get();

            if (!"ADMIN".equals(existingUser.getRole())) {
                throw new IllegalStateException(
                        "Configured admin email already belongs to a non-admin user."
                );
            }

            System.out.println("ADMIN account already exists.");
            return;
        }

        User admin = new User();

        admin.setName("System Admin");
        admin.setEmail(adminEmail);
        admin.setPassword(passwordEncoder.encode(adminPassword));
        admin.setRole("ADMIN");

        userRepository.save(admin);

        System.out.println("ADMIN account created successfully.");
    }

}
