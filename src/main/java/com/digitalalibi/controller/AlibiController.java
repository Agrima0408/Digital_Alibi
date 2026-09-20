package com.digitalalibi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlibiController {
    @GetMapping("/Hello")
    public String hello(){
        return "Digital Alibi is alive";
    }
}
