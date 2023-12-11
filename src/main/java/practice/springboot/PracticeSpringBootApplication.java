package practice.springboot;

import org.springframework.boot.SpringApplication;
import practice.springboot.component.MySpringBootAnnotation;

@MySpringBootAnnotation
public class PracticeSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(PracticeSpringBootApplication.class, args);
    }
}
