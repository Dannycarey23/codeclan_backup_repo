package com.example.codeclan.course_service.controllers;

import com.example.codeclan.course_service.models.Booking;
import com.example.codeclan.course_service.models.Course;
import com.example.codeclan.course_service.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(@RequestParam(name = "date", required = false) String date){

        if (date != null){
            return new ResponseEntity<>(bookingRepository.findAllByDate(date), HttpStatus.OK);
        }

        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/bookings/{id}")
    public ResponseEntity<Course> getBooking(@PathVariable Long id) {
        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping(value="/bookings/{id}")
    public ResponseEntity<Booking> putBooking(@RequestBody Booking booking, @PathVariable Long id){
        Booking bookingToUpdate = bookingRepository.findById(id).get();
        bookingToUpdate.setDate(booking.getDate());
        bookingToUpdate.setCourse(booking.getCourse());
        bookingToUpdate.setCustomer(booking.getCustomer());
        bookingRepository.save(bookingToUpdate);
        return new ResponseEntity<>(bookingToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value="/bookings/{id}")
    public ResponseEntity<Long> deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
