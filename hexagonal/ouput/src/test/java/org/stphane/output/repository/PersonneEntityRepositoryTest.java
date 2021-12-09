package org.stphane.output.repository;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.stphane.output.entities.PersonneEntity;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ContextConfiguration(classes = PersonneEntityRepository.class)
@RequiredArgsConstructor
@EnableJpaRepositories(basePackages = {"org.stphane.output.repository"})
@EntityScan({"org.stphane.output.entities"})
class PersonneEntityRepositoryTest {
    @Autowired
    private PersonneEntityRepository repository;

    @Test
    void createUnepersonne(){
        PersonneEntity personne = new PersonneEntity();
        personne.setNom("DYLAN");
        personne.setPrenom("BOB");
        personne.setDateNaissance(LocalDate.of(1980,5,25));
        repository.save(personne);
        assertThat(personne).isNotNull();
        assertThat(personne.getId()).isNotBlank();
    }
}
