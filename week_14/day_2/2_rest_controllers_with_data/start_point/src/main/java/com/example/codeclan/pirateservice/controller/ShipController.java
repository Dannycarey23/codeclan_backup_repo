package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ShipController {

    @Autowired
    ShipRepository shipRepository;

    @GetMapping(value = "/ships")
    public List<Ship> getAllShips(){
        return shipRepository.findAll();
    }

    @GetMapping(value = "/ships/{id}")
    public Optional<Ship> getShip(@PathVariable Long id){
        return shipRepository.findById(id);
    }
}
