package com.example.codeclan.course_service.repositories;

import com.example.codeclan.course_service.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findCoursesByStarRating(int rating);
    public List<Course> findAllByBookingsCustomerId(Long customerId);
}
