package com.digitalalibi.controller;

import com.digitalalibi.entity.Case;
import com.digitalalibi.service.CaseService;
import com.digitalalibi.entity.Evidence;
import com.digitalalibi.service.EvidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class EvidenceController {


    private EvidenceService evidenceService;
    private CaseService caseService;


    @Autowired
    public void setEvidenceService(EvidenceService evidenceService, CaseService caseService) {
        this.evidenceService = evidenceService;
        this.caseService = caseService;
    }

    @GetMapping("/api/evidences")
    public List<Evidence> findAll(){
        return evidenceService.findAll();
    }

    @GetMapping("/api/evidences/{id}")
    public Optional<Evidence> findById(@PathVariable Long id){
        return evidenceService.findById(id);
    }

    @PostMapping("/api/evidences")
    public Evidence save(@RequestBody Evidence evidence){
        return evidenceService.save(evidence);
    }

    @DeleteMapping("/api/evidences/{id}")
    public void deleteById(@PathVariable Long id){
        evidenceService.deleteById(id);
    }

    @PutMapping("/api/evidences/{id}")
    public Evidence update(@RequestBody Evidence evidence, @PathVariable Long id){
        evidence.setId(id);
        return evidenceService.save(evidence);
    }

    @PostMapping("/api/cases/{caseId}/evidences")
    public Evidence addEvidenceToCase(
            @PathVariable Long caseId,
            @RequestBody Evidence evidence) {

        Case caseEntity = caseService.findById(caseId)
                .orElseThrow(() -> new RuntimeException("Case not found"));

        evidence.setCaseEntity(caseEntity);

        return evidenceService.save(evidence);
    }

}
