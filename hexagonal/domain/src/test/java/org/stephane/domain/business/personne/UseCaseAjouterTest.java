package org.stephane.domain.business.personne;

import org.junit.jupiter.api.Test;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.mock.in.personne.MockAjouterReponse;
import org.stephane.domain.mock.in.personne.MockEnregistrerPersonne;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class UseCaseAjouterTest {
    MockEnregistrerPersonne mockRepository = new MockEnregistrerPersonne();
    MockAjouterReponse mockReponse = new MockAjouterReponse();

    @Test
    void ajouter() {
        UseCaseAjouter business = new UseCaseAjouter();
        Personne personne = Personne.Builder.newInstance()
                .nom("Solomon")
                .prenom("Castro")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build();
        business.ajouterUnePersonne(personne, mockRepository, mockReponse);
        Personne resultat = mockReponse.recuperer();


        assertThat(resultat).isNotNull();
        assertThat(resultat.getId()).isNotBlank();
        //controle si les autres propriétés non pas changées
        assertThat(resultat.getNom()).hasToString(personne.getNom());
        assertThat(resultat.getPrenom()).hasToString(personne.getPrenom());
        assertThat(resultat.getDateNaissance()).isEqualTo(personne.getDateNaissance());
    }
}
