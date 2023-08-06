package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    //TODO: Get all the distilleries for a particular region
    // Want: List<Distillery>
    // Have: region string - "Highland"
    List<Distillery> findByRegion(String region);


    //TODO: Get distilleries that have whiskies that are 12 years old
    // Want: List<Distillery>
    // Have: age (of whisky)
    List<Distillery> findByWhiskiesAge(int age);
}
