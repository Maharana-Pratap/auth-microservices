package com.example.service;

import com.example.entity.Admission;
import com.example.repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionService {
    @Autowired
    private AdmissionRepository admissionRepository;

    @Transactional
    public Admission saveAdmission(Admission entity) {
        return admissionRepository.save(entity);
    }

    @Transactional
    public Admission updateAdmission(Admission entity) {
        Optional<Admission> admission = admissionRepository.findById(entity.getId());
        if (null != admission.get()) {
            admission.get().setCurrentCount(entity.getCurrentCount());
            admission.get().setFullLength(entity.getFullLength());
            return admissionRepository.save(admission.get());
        }
        return null;
    }

    public long recordCount() {
        return admissionRepository.count();
    }

    public int latestId() {
        return admissionRepository.findLatestId();
    }
}
