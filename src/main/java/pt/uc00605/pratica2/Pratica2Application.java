package pt.uc00605.pratica2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Pratica2Application {

	public static void main(String[] args) {
		SpringApplication.run(Pratica2Application.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner initDatabase(CourseRepository courseRepository) {

		return args -> {
			courseRepository.deleteAll();
			for (int i = 0; i < 10; i++) {
				// criando o objeto course
				Course course = new Course();
				course.setName("Java com Spring " + i);
				course.setCategory(Category.BACKEND);

				// criando o 1º objeto lesson
				Lesson lesson = new Lesson();
				lesson.setName("Introdução ao Spring Boot" + i);
				lesson.setYouTubeUrl("https://www.youtube.com/watch?v=oCEvr8OpY64" +i);
				// adicionando uma lesson no objeto course
				course.getLessons().add(lesson);

				// criando o 2º objeto lesson2
				Lesson lesson2 = new Lesson();
				lesson2.setName("Introdução ao Spring Boot" + i);
				lesson2.setYouTubeUrl("https://www.youtube.com/watch?v=oCEvr8OpY64" +i);
				// adicionando uma 2a lesson no objeto course
				course.getLessons().add(lesson2);

				courseRepository.save(course);
				
			} // fim do for
		};
	}

}
