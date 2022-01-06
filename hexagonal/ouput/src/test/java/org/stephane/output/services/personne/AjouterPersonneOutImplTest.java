package org.stephane.output.services.personne;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.entities.PersonneBuilder;
import org.stephane.output.entities.PersonneEntity;
import org.stephane.output.entities.PersonneEntityBuilder;
import org.stephane.output.repository.PersonneEntityRepository;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class AjouterPersonneOutImplTest {
    private AjouterPersonneOutImpl ajouterPersonne;
    private PersonneEntityRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(PersonneEntityRepository.class);
        ajouterPersonne = new AjouterPersonneOutImpl(repository);
    }

    @Test
    void execute_retourneNull_Quand_ParamNull() {
        Personne personne = ajouterPersonne.execute(null);
        then(personne).isNull();
    }

    @Test
    void execute_retournePersonneAvecID_Quand_PersonneNotNull() {
        Personne personneIn = PersonneBuilder.aPersonne()
                .nom("Dufresne")
                .prenom("Eleanor")
                .dateNaissance(LocalDate.of(1942, 6, 19))
                .build();
        String id = UUID.randomUUID().toString();
        PersonneEntity personneMock = PersonneEntityBuilder.builder()
                .id(id)
                .nom("Dufresne")
                .prenom("Eleanor")
                .dateNaissance(LocalDate.of(1942, 6, 19))
                .build();

        given(repository.save(ArgumentMatchers.<PersonneEntity>any())).willReturn(personneMock);

        Personne personne = ajouterPersonne.execute(personneIn);
        then(personne).isNotNull();
        then(personne.getId()).isNotEmpty().hasToString(id);
    }
}
