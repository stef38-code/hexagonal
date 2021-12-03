package org.stephane.domain.business;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterReponse;
import org.stephane.domain.port.out.personne.Enregistrer;

import java.time.LocalDate;
import java.util.UUID;

class UseCasePersonneTest {
    MockEnregistrerPersonne mockSavePersonne = new MockEnregistrerPersonne();
    MockAjouterReponse mockAddReponse = new MockAjouterReponse();

    @Test
    void ajouter() {
        UseCasePersonne business = new UseCasePersonne();
        Personne personne = Personne.Builder.newInstance()
                .nom("Solomon")
                .prenom( "Castro")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build();
        business.ajouter(personne,mockSavePersonne,mockAddReponse);
        Personne resultat = mockAddReponse.recuperer();
        Assertions.assertThat(resultat).isNotNull();
        Assertions.assertThat(resultat.getId()).isNotBlank();
    }


    private class MockEnregistrerPersonne implements Enregistrer {

        @Override
        public Personne execute(Personne personne) {
            return Personne.Builder.newInstance().clone(personne).id(UUID.randomUUID().toString()).build();
        }
    }
    private class MockAjouterReponse implements AjouterReponse {
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
