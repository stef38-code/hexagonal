package org.stephane;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.service.personne.AjouterServicePersonne;
import org.stephane.tools.GenererAdresse;
import org.stephane.tools.GenererPersonne;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"org.stephane.in","org.stephane.domain", "org.stephane.output"})
@EnableJpaRepositories("org.stephane.output.repository")
@EntityScan(basePackages = {"org.stephane.output.entities"})
@EnableJpaAuditing
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(AjouterServicePersonne personneRepro) {
        LocalDate startDate = LocalDate.of(1945, 1, 1);
        LocalDate endDate = LocalDate.of(2000, 12, 31);
        GenererPersonne genererPersonne = new GenererPersonne();
        GenererAdresse genererAdresse = new GenererAdresse();
        return args -> {
            List<PersonneDto> personneDtos = genererPersonne.genererListe(10, startDate, endDate);
            personneDtos.forEach(personne -> personne.getAdresses().add(genererAdresse.generer()));
            //
            personneDtos.forEach(personneRepro::executer);
        };
    }
}
