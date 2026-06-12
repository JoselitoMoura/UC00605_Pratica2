package pt.uc00605.pratica2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.uc00605.pratica2.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}