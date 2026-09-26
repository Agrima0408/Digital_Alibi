package com.digitalalibi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cases")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caseName;
    private String caseDescription;
    private String caseStatus;
    private LocalDateTime caseCreatedAt;

    @OneToMany(mappedBy = "caseEntity")
    @JsonManagedReference
    private List<Evidence> evidences = new ArrayList<>();

    @OneToMany
    @JsonManagedReference
    private List<Suspect> suspects = new ArrayList<>();

    @OneToMany
    @JsonManagedReference
    private List<Victim> victims = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public LocalDateTime getCaseCreatedAt() {
        return caseCreatedAt;
    }

    public List<Evidence> getEvidences() {
        return evidences;
    }

    public void setEvidences(List<Evidence> evidences) {
        this.evidences = evidences;
    }

    public void setCaseCreatedAt(LocalDateTime caseCreatedAt) {
        this.caseCreatedAt = caseCreatedAt;
    }
}
