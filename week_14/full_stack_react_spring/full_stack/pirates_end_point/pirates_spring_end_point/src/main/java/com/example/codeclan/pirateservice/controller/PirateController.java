package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repository.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PirateController {
    @Autowired
    PirateRepository pirateRepository;

    @GetMapping(value = "/pirates")
    public ResponseEntity<List<Pirate>> getAllPirates(){
        return new ResponseEntity<>(pirateRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/pirates/{id}")
    public ResponseEntity getPirate(@PathVariable Long id){
        return new ResponseEntity<>(pirateRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/pirates")
    public ResponseEntity<Pirate> postPirate(@RequestBody Pirate pirate){
        pirateRepository.save(pirate);
        return new ResponseEntity<>(pirate, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/pirates/{id}")
    public ResponseEntity<Pirate> deletePirate(@PathVariable Long id) {
        Optional<Pirate> pirateToDelete = pirateRepository.findById(id);
        pirateRepository.delete(pirateToDelete.get());
        return new ResponseEntity<>(pirateToDelete.get(), HttpStatus.OK);
    }

    @PutMapping(value = "/pirates/{id}")
    public ResponseEntity<Pirate> updatePirate(@RequestBody Pirate updatedPirate, @PathVariable Long id) {
        Pirate existingPirate = pirateRepository.findById(id).get();

        existingPirate.setAge(updatedPirate.getAge());
        existingPirate.setFirstName(updatedPirate.getFirstName());
        existingPirate.setLastName(updatedPirate.getLastName());
        existingPirate.setShip(updatedPirate.getShip());

        pirateRepository.save(existingPirate);

        return new ResponseEntity<>(existingPirate, HttpStatus.OK);
    }
}
