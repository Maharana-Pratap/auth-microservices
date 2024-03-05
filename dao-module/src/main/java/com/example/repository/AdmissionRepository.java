package com.example.repository;

import com.example.entity.Admission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends CrudRepository<Admission, Integer> {
    @Query("Select max(a.id) from Admission a")
    public int findLatestId();
}
