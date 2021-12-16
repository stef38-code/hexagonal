package org.stephane.domain.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.stephane.domain.business.personne.UseCaseModifierPersonneImpl;
import org.stephane.domain.entities.PersonneBuilder;
import org.stephane.domain.mock.in.personne.MockModifierPersonne;
import org.stephane.domain.mock.in.personne.MockModifierReponse;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UseCaseModifierTest {
    MockModifierPersonne mockRepository;
    MockModifierReponse mockReponse;

    @BeforeEach
    void setUp() {
        mockRepository = new MockModifierPersonne();
        mockReponse = new MockModifierReponse();
    }

    @Test
    void modifierUnePersonne() {
        UseCaseModifier<org.stephane.domain.entities.Personne> business = new UseCaseModifierPersonneImpl();
        org.stephane.domain.entities.Personne personne = PersonneBuilder.aPersonne()
                .id(UUID.randomUUID().toString())
                .nom("Solomon")
                .prenom("Castro")
                .dateNaissance(LocalDate.now().minusYears(30))
                .build();
        business.executer(personne, mockRepository, mockReponse);
        org.stephane.domain.entities.Personne resultat = mockReponse.recuperer();


        assertThat(resultat).isNotNull();
        assertThat(resultat.getId()).isNotBlank();
        //controle si les autres propriétés non pas changées
        assertThat(resultat.getNom()).hasToString(personne.getNom());
        assertThat(resultat.getPrenom()).hasToString(personne.getPrenom());
        assertThat(resultat.getDateNaissance()).isEqualTo(personne.getDateNaissance());
    }
}
