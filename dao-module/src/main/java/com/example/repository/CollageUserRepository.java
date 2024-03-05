package com.example.repository;

import com.example.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollageUserRepository extends JpaRepository<UserCredential, Integer> {
    @Query("select u from UserCredential u where u.name= :name")
    Optional<UserCredential> getUserByName(@Param("name") String name);
}
