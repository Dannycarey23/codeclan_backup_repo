package com.codeclan.example.files_and_folders_solution.repositories;

import com.codeclan.example.files_and_folders_solution.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
