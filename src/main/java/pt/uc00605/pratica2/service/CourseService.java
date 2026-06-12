package pt.uc00605.pratica2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Positive;
import lombok.NonNull;
import pt.uc00605.pratica2.exception.ResourceNotFoundException;
import pt.uc00605.pratica2.model.Course;
import pt.uc00605.pratica2.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService (CourseRepository repository) {

        this.repository = repository;

    }

    /** Find All e um dos metodos get */
    public List<Course> findAll() {

        List<Course> courses = repository.findAll();
        // return repository.findAll();
        return courses;
    };

    /* Find byId e um dos metodos GET */

    public Course findById(@Nonnull Long id) {
        Course course = repository.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException("Course Not Found With ID: " + id));

        return course;
    }

    /** Create Courses */

    public Course createdCourse(@Nonnull Course course) {
        return this.repository.save(course);
    }

    /** Delete course */

    public void deleteCourse(@Positive @NonNull Long id) {
        this.repository.findById(id).map(data -> {
            this.repository.deleteById(id);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("Course já deletado ou inexistente" + id));

    }

    /***Update course */

    public Course updateCourse(@Positive @NonNull Long id, Course frontCourse) {
        /** 1º buscar para a máquina o que temos no banco de dados */
        /** 2º tenho que criar uma variável que tem o course atualizado */
        return this.repository.findById(id).map(backCourse -> {
            backCourse.setName(frontCourse.getName());
            backCourse.setCategory(frontCourse.getCategory());
            /** tenho que apagar a minha lista que está em memória */
            backCourse.getLessons().clear();
            frontCourse.getLessons().forEach(data -> backCourse.getLessons().add(data));
            /** salvando no banco de dados */
            this.repository.save(backCourse);
            /** retornando para frontend o objeto atualiado */
            return backCourse;
        }).orElseThrow(() -> new ResourceNotFoundException("Course not found ID: " + id));
    }
          
}