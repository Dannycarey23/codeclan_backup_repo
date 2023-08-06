package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;


    /**
     * Handles routes and filters:
     *  GET  /distilleries
     *  GET  /distilleries?region=Speyside
     *  GET  /distilleries?whiskyAge=12
     * @return `ResponseEntity<List<Distillery>>`
     */
    @GetMapping(value = "/distilleries")
    public ResponseEntity getAllDistilleriesAndFilters(
            @RequestParam(required = false, name = "region") String region,
            @RequestParam(required = false, name = "whiskyAge") Integer whiskyAge

    ){
        // GET  /distilleries?region=Speyside
        if (region != null){
            return new ResponseEntity(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }
        // GET /distilleries?whiskyAge=12
        if (whiskyAge != null){
            return new ResponseEntity(distilleryRepository.findByWhiskiesAge(whiskyAge), HttpStatus.OK);
        }
        // GET /distilleries
        return new ResponseEntity(distilleryRepository.findAll(), HttpStatus.OK);

    }

}
