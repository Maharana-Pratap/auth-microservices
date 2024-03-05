package com.example.controller;

import com.example.entity.Admission;
import com.example.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admission")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @PostMapping("/add")
    public ResponseEntity<?> addAdmission(@RequestBody Admission admission) {
       long count = admissionService.recordCount();
       if(count == 0) {
           return ResponseEntity.ok(admissionService.saveAdmission(admission));
       }
        return ResponseEntity.badRequest().body(new Exception("Error in add admission!!").getLocalizedMessage());
    }

    @PutMapping("/update")
    public ResponseEntity<?> updteAdmission(@RequestBody Admission admission) {
        long count = admissionService.recordCount();
        if(count > 0) {
            int admissionId = admissionService.latestId();
            admission.setId(admissionId);
            return ResponseEntity.ok(admissionService.updateAdmission(admission));
        }
        return ResponseEntity.badRequest().body(new Exception("Error in update admission!!").getLocalizedMessage());
    }
}
