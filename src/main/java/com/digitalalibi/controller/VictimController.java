package com.digitalalibi.controller;
import com.digitalalibi.entity.Victim;
import com.digitalalibi.service.VictimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VictimController {
    private VictimService victimService;

    @Autowired
    public VictimController(VictimService victimService) {
        this.victimService = victimService;
    }

    @GetMapping("/api/victims")
    public List<Victim> getAllVictims() {
        return victimService.findAll();
    }

    @GetMapping("/api/victims/{id}")
    public Optional<Victim> getVictimById(@PathVariable Long id) {
        return victimService.findById(id);
    }

    @PostMapping("/api/victims")
    public Victim saveVictim(@RequestBody Victim victim) {
        return victimService.save(victim);
    }

    @DeleteMapping("/api/victims/{id}")
    public void deleteVictimById(@PathVariable Long id){
        victimService.deleteById(id);
    }

    @PutMapping("/api/victims/{id}")
    public Victim updateVictimById(@PathVariable Long id, @RequestBody Victim victim) {
        victim.setId(id);
        return victimService.save(victim);
    }
}
