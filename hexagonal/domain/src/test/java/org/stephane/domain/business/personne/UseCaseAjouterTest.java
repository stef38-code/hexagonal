package org.stephane.domain.business.personne;

import org.junit.jupiter.api.Test;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterReponse;
import org.stephane.domain.port.out.personne.Enregistrer;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UseCaseAjouterTest {
    MockEnregistrerPersonne mockSavePersonne = new MockEnregistrerPersonne();
    MockAjouterReponse mockAddReponse = new MockAjouterReponse();

    @Test
    void ajouter() {
        UseCaseAjouter business = new UseCaseAjouter();
        Personne personne = Personne.Builder.newInstance()
                .nom("Solomon")
                .prenom("Castro")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build();
        business.ajouter(personne, mockSavePersonne, mockAddReponse);
        Personne resultat = mockAddReponse.recuperer();


        assertThat(resultat).isNotNull();
        assertThat(resultat.getId()).isNotBlank();
        //controle si les autres propriétés non pas changées
        assertThat(resultat.getNom()).hasToString(personne.getNom());
        assertThat(resultat.getPrenom()).hasToString(personne.getPrenom());
        assertThat(resultat.getDateNaissance()).isEqualTo(personne.getDateNaissance());
    }

    @Test
    void modifierUnePersonne() {
    }

    @Test
    void supprimerUnePersonne() {
    }

    @Test
    void testSupprimerUnePersonne() {
    }


    private static class MockEnregistrerPersonne implements Enregistrer {

        @Override
        public Personne execute(Personne personne) {
            return Personne.Builder.newInstance().clone(personne).id(UUID.randomUUID().toString()).build();
        }
    }

    private static class MockAjouterReponse implements AjouterReponse {
        private Personne resultat;

        @Override
        public void donner(Personne resultat) {
            this.resultat = resultat;
        }

        @Override
        public Personne recuperer() {
            return resultat;
        }
    }
}
