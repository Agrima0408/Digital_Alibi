package com.digitalalibi.controller;

import com.digitalalibi.entity.User;
import com.digitalalibi.repository.UserRepository;
import com.digitalalibi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createdUser(user);
    }
//    @GetMapping
//    public String test(){
//        return "Digital Alibi is Working!";
//    }
}
