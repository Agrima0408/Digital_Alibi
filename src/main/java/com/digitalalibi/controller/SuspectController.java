package com.digitalalibi.controller;

import com.digitalalibi.entity.Suspect;
import com.digitalalibi.service.SuspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SuspectController {
    private SuspectService suspectService;

    @Autowired
    public SuspectController(SuspectService suspectService) {
        this.suspectService = suspectService;
    }

    @GetMapping("/api/suspects")
    public List<Suspect> getAllSuspects(){
        return suspectService.findAll();
    }

    @GetMapping("/api/suspects/{id}")
    public Optional<Suspect> getSuspectById(@PathVariable Long id){
        return suspectService.findById(id);
    }

    @PostMapping("/api/suspects")
    public Suspect createSuspect(@RequestBody Suspect suspect){
        return suspectService.save(suspect);
    }

    @DeleteMapping("/api/suspects/{id}")
    public void deleteSuspectById(@PathVariable Long id){
        suspectService.deleteById(id);
    }
    
    @PutMapping{"/api/suspects/{id}"}
    public Suspect updateSuspectById(@PathVariable Long id, @RequestBody Suspect suspect){
        suspect.setId(id);
        return suspectService.save(suspect);
    }
}
