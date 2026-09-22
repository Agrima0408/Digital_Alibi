package com.digitalalibi.service;

import com.digitalalibi.entity.Evidence;
import com.digitalalibi.repository.EvidenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvidenceService {
    private final EvidenceRepository evidenceRepository;
    public EvidenceService(EvidenceRepository evidenceRepository) {
        this .evidenceRepository = evidenceRepository;
    }
    public List<Evidence> findAll(){
        return evidenceRepository.findAll();
    }

    public Optional<Evidence> findById(Long id) {
        return evidenceRepository.findById(id);
    }

    public Evidence save(Evidence evidence){
        return evidenceRepository.save(evidence);
    }

    public void deleteById(Long id){
        evidenceRepository.deleteById(id);
    }
}
