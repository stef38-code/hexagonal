package org.stephane.output.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.stephane.output.entities.AdresseEntity;
import org.stephane.output.entities.PersonneEntity;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(properties = {
        "spring.main.banner-mode=off",
        "spring.jpa.properties.hibernate.show_sql=true",
        "spring.jpa.properties.hibernate.format_sql=true",
        "logging.level.ROOT= DEBUG",
        "logging.level.org.springframework.test.context.transaction= DEBUG",
        "logging.level.org.hibernate.SQL= DEBUG",
        "logging.level.org.hibernate.type.descriptor.sql=trace"
})
@ContextConfiguration(classes = PersonneEntityRepository.class)
@RequiredArgsConstructor
@EnableJpaRepositories(basePackages = {"org.stephane.output.repository"})
@EntityScan({"org.stephane.output.entities"})
@Slf4j
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
    @Test
    void createUnepersonneAvecUneAdresse(){
        AdresseEntity adresse = new AdresseEntity();
        adresse.setAppartementEscalierEtage("Appart. 18");
        adresse.setBatimentResidence("Bat. paradis");
        adresse.setNumeroNomVoie("298, boulevard Margaud Didier");
        adresse.setComplementAdresse("");
        adresse.setCodePostal("53039");
        adresse.setVille("PasquierVille");
        adresse.setPays("France");

        PersonneEntity personne = new PersonneEntity();
        personne.setNom("DYLAN");
        personne.setPrenom("BOB");
        personne.setDateNaissance(LocalDate.of(1980,5,25));
        personne.getAdresses().add(adresse);

        repository.save(personne);
        assertThat(personne).isNotNull();
        assertThat(personne.getId()).isNotBlank();
        log.info("Id personne: {}",personne.getId());
        assertThat(adresse.getId()).isNotBlank();
        log.info("Id adresse: {}",adresse.getId());
    }
}
