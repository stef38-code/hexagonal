package org.stephane.domain.business.personne;

import org.junit.jupiter.api.Test;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.mock.in.personne.MockModifierPersonne;
import org.stephane.domain.mock.in.personne.MockModifierReponse;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UseCaseModifierTest {
    MockModifierPersonne mockRepository = new MockModifierPersonne();
    MockModifierReponse mockReponse = new MockModifierReponse();

    @Test
    void modifierUnePersonne() {
        UseCaseModifier business = new UseCaseModifier();
        Personne personne = Personne.Builder.newInstance()
                .id(UUID.randomUUID().toString())
                .nom("Solomon")
                .prenom("Castro")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build();
        business.modifierUnePersonne(personne, mockRepository, mockReponse);
        Personne resultat = mockReponse.recuperer();


        assertThat(resultat).isNotNull();
        assertThat(resultat.getId()).isNotBlank();
        //controle si les autres propriétés non pas changées
        assertThat(resultat.getNom()).hasToString(personne.getNom());
        assertThat(resultat.getPrenom()).hasToString(personne.getPrenom());
        assertThat(resultat.getDateNaissance()).isEqualTo(personne.getDateNaissance());
    }
}
