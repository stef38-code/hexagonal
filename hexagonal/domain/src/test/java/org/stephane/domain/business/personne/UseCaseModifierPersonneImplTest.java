package org.stephane.domain.business.personne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.stephane.domain.business.UseCaseModifier;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.entities.PersonneBuilder;
import org.stephane.domain.mock.in.personne.MockModifierPersonneOut;
import org.stephane.domain.mock.in.personne.MockModifierReponse;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UseCaseModifierPersonneImplTest {
    MockModifierPersonneOut mockRepository;
    MockModifierReponse mockReponse;

    @BeforeEach
    void setUp() {
        mockRepository = new MockModifierPersonneOut();
        mockReponse = new MockModifierReponse();
    }

    @Test
    void modifierUnePersonne() {
        UseCaseModifier<Personne> business = new UseCaseModifierPersonneImpl();
        Personne personne = PersonneBuilder.aPersonne()
                .id(UUID.randomUUID().toString())
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
