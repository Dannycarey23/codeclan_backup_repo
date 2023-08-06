package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.repository.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RaidController {

    @Autowired
    RaidRepository raidRepository;


    @GetMapping(value = "/raids/{id}")
    public ResponseEntity getRaid(@PathVariable Long id){
        return new ResponseEntity<>(raidRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/raids")
    public ResponseEntity<Raid> createRaid(@RequestBody Raid raid){
        raidRepository.save(raid);
        return new ResponseEntity<>(raid, HttpStatus.CREATED);
    }

    @GetMapping(value = "/raids")
    public ResponseEntity<List<Raid>> findRaidsFilterByLocation(
            @RequestParam(name="location", required = false) String location) {
        if (location != null) { // check if there's a ?location=something on the URL
            return new ResponseEntity<>(raidRepository.findRaidByLocation(location), HttpStatus.OK);
        }
        return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
    }

}
