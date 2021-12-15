package org.stephane.domain.business;

import org.junit.jupiter.api.Test;
import org.stephane.domain.business.personne.UseCaseAjouterPersonneImpl;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.mock.in.personne.MockAjouterReponse;
import org.stephane.domain.mock.in.personne.MockEnregistrerPersonne;
import org.stephane.domain.port.in.AjouterReponse;
import org.stephane.domain.port.out.Enregistrer;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class UseCaseAjouterTest {
    Enregistrer<Personne> mockRepository = new MockEnregistrerPersonne();
    AjouterReponse<Personne> mockReponse = new MockAjouterReponse();

    @Test
    void ajouter() {
        UseCaseAjouter<Personne> business = new UseCaseAjouterPersonneImpl();
        Personne personne = Personne.Builder.newInstance()
                .nom("Solomon")
                .prenom("Castro")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build();
        business.executer(personne, mockRepository, mockReponse);
        Personne resultat = mockReponse.recuperer();


        assertThat(resultat).isNotNull();
        assertThat(resultat.getId()).isNotBlank();
        //controle si les autres propriétés non pas changées
        assertThat(resultat.getNom()).hasToString(personne.getNom());
        assertThat(resultat.getPrenom()).hasToString(personne.getPrenom());
        assertThat(resultat.getDateNaissance()).isEqualTo(personne.getDateNaissance());
    }
}
