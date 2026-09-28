package com.digitalalibi.controller;

import com.digitalalibi.entity.Case;
import com.digitalalibi.entity.Suspect;
import com.digitalalibi.service.CaseService;
import com.digitalalibi.service.SuspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SuspectController {
    private SuspectService suspectService;
    private CaseService caseService;

    @Autowired
    public SuspectController(SuspectService suspectService , CaseService caseService) {
        this.suspectService = suspectService;
        this.caseService = caseService;
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
    
    @PutMapping("/api/suspects/{id}")
    public Suspect updateSuspectById(@PathVariable Long id, @RequestBody Suspect suspect){
        suspect.setId(id);
        return suspectService.save(suspect);
    }

    @PostMapping("/api/cases/{caseId}/suspects")
    public Suspect addSuspectToCase(
            @PathVariable Long caseId,
            @RequestBody Suspect suspect) {

        Case caseEntity = caseService.findById(caseId)
                .orElseThrow(() -> new RuntimeException("Case not found"));

        suspect.setCaseEntity(caseEntity);

        return suspectService.save(suspect);
    }


}
