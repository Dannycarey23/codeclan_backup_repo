package com.codeclan.example.files_and_folders_solution.controllers;

import com.codeclan.example.files_and_folders_solution.models.Folder;
import com.codeclan.example.files_and_folders_solution.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping("/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        List<Folder> foundFolders = folderRepository.findAll();
        return new ResponseEntity<>(foundFolders, HttpStatus.OK);
    }

    @GetMapping("/folders/{id}")
    public ResponseEntity getFolderById(@PathVariable Long id){
        Optional<Folder> foundFolder = folderRepository.findById(id);
        return new ResponseEntity(foundFolder, HttpStatus.OK);
    }

    @PostMapping("/folders")
    public ResponseEntity<Folder> postFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

}
