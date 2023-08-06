package com.example.codeclan.pirateservice.repository;

import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaidRepository extends JpaRepository<Raid, Long> {
    List<Raid> findRaidByLocation(String location);
    List<Raid> findByPiratesShip(Ship ship);
}
