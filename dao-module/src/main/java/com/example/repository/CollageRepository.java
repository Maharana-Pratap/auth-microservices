package com.example.repository;

import com.example.entity.Collage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollageRepository extends CrudRepository<Collage,Integer> {
    @Query("SELECT c from Collage c")
    public List<Collage> allCollageRecords();
}
