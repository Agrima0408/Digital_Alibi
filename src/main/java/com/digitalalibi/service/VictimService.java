package com.digitalalibi.service;

import com.digitalalibi.entity.Victim;
import com.digitalalibi.repository.VictimRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VictimService {
    private final VictimRepository victimRepository;
    public VictimService(VictimRepository victimRepository) {
        this.victimRepository = victimRepository;
    }

    public List<Victim> findAll(){
        return victimRepository.findAll();
    }
    public Optional<Victim> findById(Long id){
        return victimRepository.findById(id);
    }
    public Victim save(Victim victim){
        return victimRepository.save(victim);
    }
    public void deleteById(Long id){
        victimRepository.deleteById(id);
    }
}
