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

@DataJpaTest
@ContextConfiguration(classes = AdresseEntityRepository.class)
@RequiredArgsConstructor
@EnableJpaRepositories(basePackages = {"org.stephane.output.repository"})
@EntityScan({"org.stephane.output.entities"})
@Slf4j
class AdresseEntityRepositoryTest {
    @Autowired
    private AdresseEntityRepository repository;

    @Test
    void createUneAdresseAvecUnePersonne() {
        PersonneEntity personne = new PersonneEntity();
        personne.setNom("Timothée");
        personne.setPrenom("Maurice");
        personne.setDateNaissance(LocalDate.of(1992, 2, 29));


        AdresseEntity adresse = new AdresseEntity();
        adresse.setAppartementEscalierEtage("Appart. 18");
        adresse.setBatimentResidence("Bat. paradis");
        adresse.setNumeroNomVoie("298, boulevard Margaud Didier");
        adresse.setComplementAdresse("");
        adresse.setCodePostal("53039");
        adresse.setVille("PasquierVille");
        adresse.setPays("France");
        adresse.getPersonnes().add(personne);

        repository.save(adresse);
        assertThat(adresse).isNotNull();
        assertThat(adresse.getId()).isNotBlank();
        log.info("Id adresse: {}",adresse.getId());
        assertThat(personne.getId()).isNotBlank();
        log.info("Id personne: {}",personne.getId());
    }
}
