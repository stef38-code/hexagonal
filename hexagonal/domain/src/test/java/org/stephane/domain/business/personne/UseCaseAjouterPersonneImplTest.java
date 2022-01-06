package org.stephane.domain.business.personne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.stephane.domain.business.UseCaseAjouter;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.entities.PersonneBuilder;
import org.stephane.domain.mock.in.personne.MockAjouterPersonne;
import org.stephane.domain.mock.in.personne.MockAjouterReponse;
import org.stephane.domain.port.in.AjouterReponse;
import org.stephane.domain.port.out.AjouterOut;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

class UseCaseAjouterPersonneImplTest {
    AjouterOut<Personne> mockRepository;
    AjouterReponse<Personne> mockReponse;

    @BeforeEach
    void setUp() {
        mockRepository = new MockAjouterPersonne();
        mockReponse = new MockAjouterReponse();
    }

    @Test
    void ajouter() {
        UseCaseAjouter<Personne> business = new UseCaseAjouterPersonneImpl();
        Personne personne = PersonneBuilder.aPersonne()
                .nom("Solomon")
                .prenom("Castro")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build();
        business.executer(personne, mockRepository, mockReponse);
        Personne resultat = mockReponse.recuperer();


        then(resultat).isNotNull();
        then(resultat.getId()).isNotBlank();
        //controle si les autres propriétés non pas changées
        then(resultat.getNom()).hasToString(personne.getNom());
        then(resultat.getPrenom()).hasToString(personne.getPrenom());
        then(resultat.getDateNaissance()).isEqualTo(personne.getDateNaissance());
    }
}
