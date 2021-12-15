package org.stephane.domain.business.personne;

import org.junit.jupiter.api.Test;
import org.stephane.domain.business.UseCaseSupprimer;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.mock.in.personne.MockSupprimerPersonne;
import org.stephane.domain.mock.in.personne.MockSupprimerReponse;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UseCaseSupprimerTest {
    MockSupprimerPersonne mockRepository = new MockSupprimerPersonne();
    MockSupprimerReponse mockReponse = new MockSupprimerReponse();
    @Test
    void supprimerUnePersonne() {
        UseCaseSupprimer<Personne> business = new UseCaseSupprimerPersonneImpl();
        Personne personne = Personne.Builder.newInstance()
                .id(UUID.randomUUID().toString())
                .nom("Solomon")
                .prenom("Castro")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build();
        business.executer(personne, mockRepository, mockReponse);
        boolean resultat = mockReponse.recuperer();
        assertThat(resultat).isTrue();
    }

    @Test
    void testSupprimerUnePersonne() {
        String idPersonne = UUID.randomUUID().toString();
        UseCaseSupprimerPersonneImpl business = new UseCaseSupprimerPersonneImpl();
        business.executer(idPersonne, mockRepository, mockReponse);
        boolean resultat = mockReponse.recuperer();
        assertThat(resultat).isTrue();
    }
}
