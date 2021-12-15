package org.stephane.in;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"org.stephane.in","org.stephane.output"})
@EnableJpaRepositories("org.stephane.output.repository")
@EntityScan( basePackages = {"org.stephane.output.entities"} )
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
