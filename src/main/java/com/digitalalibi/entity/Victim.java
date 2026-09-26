package com.digitalalibi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Victim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String victimName;
    private int victimAge;
    private String victimOccupation;
    private String victimDescription;

    @ManyToOne
    @JsonBackReference
    private Case caseEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVictimName() {
        return victimName;
    }

    public void setVictimName(String victimName) {
        this.victimName = victimName;
    }

    public int getVictimAge() {
        return victimAge;
    }

    public void setVictimAge(int victimAge) {
        this.victimAge = victimAge;
    }

    public String getVictimOccupation() {
        return victimOccupation;
    }

    public void setVictimOccupation(String victimOccupation) {
        this.victimOccupation = victimOccupation;
    }

    public String getVictimDescription() {
        return victimDescription;
    }

    public void setVictimDescription(String victimDescription) {
        this.victimDescription = victimDescription;
    }

    public Case getCaseEntity() {
        return caseEntity;
    }

    public void setCaseEntity(Case caseEntity) {
        this.caseEntity = caseEntity;
    }
}
