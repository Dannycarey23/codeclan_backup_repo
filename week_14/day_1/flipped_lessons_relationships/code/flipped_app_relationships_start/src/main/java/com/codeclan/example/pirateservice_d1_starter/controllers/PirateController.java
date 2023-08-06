package com.codeclan.example.pirateservice_d1_starter.controllers;

import com.codeclan.example.pirateservice_d1_starter.models.Pirate;
import com.codeclan.example.pirateservice_d1_starter.repositories.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
public class PirateController {

    @Autowired
    PirateRepository pirateRepository;

    @GetMapping(value = "/pirates")
    public List<Pirate> getAllPirates(){
      return  pirateRepository.findAll();
    }

    @GetMapping(value = "/pirates/{id}")
    public Optional<Pirate> getPirate(@PathVariable Long id){
        return pirateRepository.findById(id);
    }
}
