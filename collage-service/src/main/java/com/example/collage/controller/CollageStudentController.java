package com.example.collage.controller;

import com.example.entity.Collage;
import com.example.service.CollageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collage")
public class CollageStudentController {
    @Autowired
    private CollageService collageSevice;

    @PostMapping("/student")
    public ResponseEntity<?> studentCollage(@RequestBody Collage entity) {
        List<Collage> records = collageSevice.studentAdmission(entity);
        if(!records.isEmpty()) {
            return ResponseEntity.ok(records);
        }
        return ResponseEntity.badRequest().body(new Exception("Error in save collage record!!!").getLocalizedMessage());
    }

    @GetMapping("/all")
    public ResponseEntity<?> findallStudents() {
       return ResponseEntity.ok(collageSevice.allStudents());
    }
}
