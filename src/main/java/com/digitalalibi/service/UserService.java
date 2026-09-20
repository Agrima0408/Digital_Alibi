package com.digitalalibi.service;

import com.digitalalibi.entity.User;
import com.digitalalibi.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createdUser(User user){
        return userRepository.save(user);
    }
}
