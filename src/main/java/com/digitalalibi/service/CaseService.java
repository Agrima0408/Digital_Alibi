package com.digitalalibi.service;

import com.digitalalibi.entity.Case;
import com.digitalalibi.repository.CaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseService {
    private final CaseRepository caseRepository;

    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public List<Case> findAll(){
        return caseRepository.findAll();
    }

    public Optional<Case> findById(Long id) {
        return caseRepository.findById(id);
    }

    public Case save(Case c){
        return caseRepository.save(c);
    }

    public void deleteById(Long id){
        caseRepository.deleteById(id);
    }
}
