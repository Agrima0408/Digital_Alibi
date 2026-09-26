package com.digitalalibi.service;

import com.digitalalibi.entity.Suspect;
import com.digitalalibi.repository.SuspectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuspectService {
    private final SuspectRepository suspectRepository;
    public SuspectService(SuspectRepository suspectRepository) {
        this.suspectRepository = suspectRepository;
    }

    public List<Suspect> findAll(){
        return suspectRepository .findAll();
    }
    public Optional<Suspect> findById(Long id){
        return suspectRepository.findById(id);
    }
    public Suspect save (Suspect suspect){
        return suspectRepository.save(suspect);
    }

    public void deleteById(Long id){
        suspectRepository.deleteById(id);
    }
}
