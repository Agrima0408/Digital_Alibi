package com.digitalalibi.controller;

import com.digitalalibi.entity.Case;
import com.digitalalibi.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CaseController {
    CaseService caseService;
    @Autowired
    public void setCaseService(CaseService caseService) {
        this.caseService = caseService;
    }
    @GetMapping("/api/cases")
        public List<Case> getAllCases(){
            return caseService.findAll();
        }

    @GetMapping("/api/cases/{id}")
    public Optional<Case> getCase(@PathVariable Long id){
        return caseService.findById(id);
    }

    @PostMapping("/api/cases")
    public Case createCase(@RequestBody Case c){
        return caseService.save(c);
    }
}

