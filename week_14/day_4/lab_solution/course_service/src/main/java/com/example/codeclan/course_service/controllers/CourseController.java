package com.example.codeclan.course_service.controllers;

import com.example.codeclan.course_service.models.Course;
import com.example.codeclan.course_service.models.Customer;
import com.example.codeclan.course_service.repositories.CourseRepository;
import com.example.codeclan.course_service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(@RequestParam(name = "stars", required = false) Integer rating){

        if (rating != null){
            return new ResponseEntity<>(courseRepository.findCoursesByStarRating(rating), HttpStatus.OK);
        }

        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @PutMapping(value="/courses/{id}")
    public ResponseEntity<Course> putCourse(@RequestBody Course course, @PathVariable Long id){
        Course courseToUpdate = courseRepository.findById(id).get();
        courseToUpdate.setName(course.getName());
        courseToUpdate.setBookings(course.getBookings());
        courseToUpdate.setStarRating(course.getStarRating());
        courseToUpdate.setTown(course.getTown());
        courseRepository.save(courseToUpdate);
        return new ResponseEntity<>(courseToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value="/courses/{id}")
    public ResponseEntity<Long> deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value="/courses/{id}/customers")
    public ResponseEntity<List<Customer>> getCustomersForCourse(@PathVariable Long id,
                                                                @RequestParam(name = "town", required = false) String town,
                                                                @RequestParam(name = "age", required = false) Integer age) {
        if (town != null){
            if (age != null){
                return new ResponseEntity<>(customerRepository.findAllByTownAndAgeGreaterThanAndBookingsCourseId(town, age, id), HttpStatus.OK);
            }

            return new ResponseEntity<>(customerRepository.findAllByTownAndBookingsCourseId(town, id), HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepository.findAllByBookingsCourseId(id), HttpStatus.OK);
    }




//    Alternative: Using routes instead of query strings


    @GetMapping(value = "/courses/stars/{rating}")
    public ResponseEntity<List<Course>> coursesForStarRating(@PathVariable int rating){
        return new ResponseEntity(courseRepository.findCoursesByStarRating(rating), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}/customers/town/{town}")
    public ResponseEntity<List<Customer>> customersForCourseInTown(@PathVariable Long id, @PathVariable String town){
        return new ResponseEntity<>(customerRepository.findAllByTownAndBookingsCourseId(town, id), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}/customers/town/{town}/age/{age}")
    public ResponseEntity<List<Customer>> customersForCourseInTown(@PathVariable Long id, @PathVariable String town, @PathVariable int age){
        return new ResponseEntity<>(customerRepository.findAllByTownAndAgeGreaterThanAndBookingsCourseId(town, age, id), HttpStatus.OK);
    }
}
