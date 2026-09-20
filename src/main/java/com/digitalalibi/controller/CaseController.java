package com.digitalalibi.controller;

import com.digitalalibi.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseController {
    CaseService caseService;
    @Autowired
    public void setCaseService(CaseService caseService) {
        this.caseService = caseService;
    }
}

