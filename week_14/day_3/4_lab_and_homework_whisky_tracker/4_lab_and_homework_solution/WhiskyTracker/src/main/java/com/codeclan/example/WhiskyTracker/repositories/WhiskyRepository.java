package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    //TODO: Get all the whiskies for a particular year
    // What do I want back: List<Whisky>
    // What do I have - year 1995
    List<Whisky> findByYear(int year);


    //TODO: Get all the whisky from a particular distillery that's a specific age
    // find all the whisky from Glendronach that's 15 years old
    // Want: List<Whisky>
    // Have: Distillery name: ("Glendronach") AND a whisky age (15)
    List<Whisky> findByDistilleryNameAndAge(String distilleryName, int age);
    List<Whisky> findByDistilleryIdAndAge(Long distId, int age); // Bonus, just to show it can be done.


    //TODO: Get all the whisky from a particular region
    // Want: List<Whisky>
    // Have : Region
    List<Whisky> findByDistilleryRegion(String region);
}
