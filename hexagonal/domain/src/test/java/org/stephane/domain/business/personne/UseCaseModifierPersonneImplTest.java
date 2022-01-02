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

import static org.assertj.core.api.BDDAssertions.then;

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


        then(resultat).isNotNull();
        then(resultat.getId()).isNotBlank();
        //controle si les autres propriétés non pas changées
        then(resultat.getNom()).hasToString(personne.getNom());
        then(resultat.getPrenom()).hasToString(personne.getPrenom());
        then(resultat.getDateNaissance()).isEqualTo(personne.getDateNaissance());
    }
}
