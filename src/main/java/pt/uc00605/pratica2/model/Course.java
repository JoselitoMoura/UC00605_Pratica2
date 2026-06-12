package pt.uc00605.pratica2.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import pt.uc00605.pratica2.enums.Category;
import pt.uc00605.pratica2.enums.Status;

//@Data
@Entity
@SQLDelete(sql = "UPDATE course SET status = 1 WHERE id = ?")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    // @org.hibernate.validator.constraints.Length(min = 2, max = 100)
    @Length(min = 2, max = 100)
    private String name;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(length = 10, nullable = false)
    private Status status = Status.ACTIVE;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "course_id")
    private List<Lesson> lessons = new ArrayList<>();

    // Construtor vazio
    public Course() {
    }

    // Construtor com todos os atributos
    public Course( String name, Category category, Status status, List<Lesson> lessons) {
        
        this.name = name;
        this.category = category;
        this.status = status;
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
    
}