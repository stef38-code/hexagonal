package org.stephane.domain.business.personne;

import org.junit.jupiter.api.Test;
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
        UseCaseSupprimer business = new UseCaseSupprimer();
        Personne personne = Personne.Builder.newInstance()
                .id(UUID.randomUUID().toString())
                .nom("Solomon")
                .prenom("Castro")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build();
        business.supprimerUnePersonne(personne, mockRepository, mockReponse);
        String resultat = mockReponse.recuperer();
        assertThat(resultat).isNotNull().hasToString(personne.getId());
    }

    @Test
    void testSupprimerUnePersonne() {
        String idPersonne = UUID.randomUUID().toString();
        UseCaseSupprimer business = new UseCaseSupprimer();
        business.supprimerUnePersonne(idPersonne, mockRepository, mockReponse);
        String resultat = mockReponse.recuperer();
        assertThat(resultat).isNotNull().hasToString(idPersonne);
    }
}
