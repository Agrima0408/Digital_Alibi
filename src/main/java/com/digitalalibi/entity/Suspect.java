package com.digitalalibi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Suspect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String suspectName;
    private int suspectAge;
    private String suspectOccupation;
    private String suspectDescription;
    private String suspectStatus;

    @ManyToOne
    @JsonBackReference
    private Case caseEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuspectName() {
        return suspectName;
    }

    public void setSuspectName(String suspectName) {
        this.suspectName = suspectName;
    }

    public int getSuspectAge() {
        return suspectAge;
    }

    public void setSuspectAge(int suspectAge) {
        this.suspectAge = suspectAge;
    }

    public String getSuspectOccupation() {
        return suspectOccupation;
    }

    public void setSuspectOccupation(String suspectOccupation) {
        this.suspectOccupation = suspectOccupation;
    }

    public String getSuspectDescription() {
        return suspectDescription;
    }

    public void setSuspectDescription(String suspectDescription) {
        this.suspectDescription = suspectDescription;
    }

    public String getSuspectStatus() {
        return suspectStatus;
    }

    public void setSuspectStatus(String suspectStatus) {
        this.suspectStatus = suspectStatus;
    }

    public Case getCaseEntity() {
        return caseEntity;
    }

    public void setCaseEntity(Case caseEntity) {
        this.caseEntity = caseEntity;
    }
}
