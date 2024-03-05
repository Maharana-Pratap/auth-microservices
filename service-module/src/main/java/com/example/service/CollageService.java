package com.example.service;

import com.example.entity.Collage;
import com.example.repository.CollageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CollageService {
    @Autowired
    private CollageRepository collageRepository;

    @Transactional
    public List<Collage> studentAdmission(Collage entity) {
        Collage collage =  collageRepository.save(entity);
        return collageRepository.allCollageRecords();
    }

    public List<Collage> allStudents() {
        return collageRepository.allCollageRecords();
    }
}
