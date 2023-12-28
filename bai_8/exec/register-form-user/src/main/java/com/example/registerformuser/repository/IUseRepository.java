package com.example.registerformuser.repository;

import com.example.registerformuser.model.Use;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUseRepository extends JpaRepository<Use,Integer> {
    Optional<Use> findByEmail(String value);
}
