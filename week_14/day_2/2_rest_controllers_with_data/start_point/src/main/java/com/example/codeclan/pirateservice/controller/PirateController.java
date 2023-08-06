package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repository.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PirateController {
    @Autowired
    PirateRepository pirateRepository;


    @GetMapping(value = "/pirates")
    public List<Pirate> getAllPirates(){
        return pirateRepository.findAll();
    }

    @GetMapping(value = "/pirates/{id}")
    public Optional<Pirate> getPirate(@PathVariable Long id){
        return pirateRepository.findById(id);
    }

}
