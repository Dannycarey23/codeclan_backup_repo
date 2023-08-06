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
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){

        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer, @PathVariable Long id){
        Customer foundCustomer = customerRepository.findById(id).get();
        foundCustomer.setName(customer.getName());
        foundCustomer.setAge(customer.getAge());
        foundCustomer.setBookings(customer.getBookings());
        foundCustomer.setTown(customer.getTown());
        customerRepository.save(foundCustomer);
        return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Long> deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{customerId}/courses")
    public ResponseEntity<List<Course>> getCoursesForCustomer(@PathVariable Long customerId) {
        return new ResponseEntity<>(courseRepository.findAllByBookingsCustomerId(customerId), HttpStatus.OK);
    }
}
