package com.codeclan.example.files_and_folders_solution.controllers;

import com.codeclan.example.files_and_folders_solution.models.File;
import com.codeclan.example.files_and_folders_solution.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping("/files")
    public ResponseEntity<List<File>> getAllFiles(){
        List<File> foundFiles = fileRepository.findAll();
        return new ResponseEntity<>(foundFiles, HttpStatus.OK);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity getFileById(@PathVariable Long id){
        Optional<File> foundFile = fileRepository.findById(id);
        return new ResponseEntity(foundFile, HttpStatus.OK);
    }

    @PostMapping("/files")
    public ResponseEntity<File> postFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }
}
