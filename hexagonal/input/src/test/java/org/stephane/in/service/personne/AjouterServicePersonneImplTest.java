package org.stephane.in.service.personne;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.stephane.domain.port.in.personne.AjouterReponsePersonne;
import org.stephane.domain.port.out.personne.AjouterPersonneOut;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.dto.PersonneDtoBuilder;
import org.stephane.output.entities.PersonneEntity;
import org.stephane.output.entities.PersonneEntityBuilder;
import org.stephane.output.repository.PersonneEntityRepository;
import org.stephane.output.services.personne.AjouterPersonneOutImpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;


class AjouterServicePersonneImplTest {


    private AjouterReponsePersonne reponse;
    private PersonneEntityRepository repository;
    private AjouterPersonneOut ajouter;
    private AjouterServicePersonne servicePersonne;


    @BeforeEach
    void setUp() {
        repository = mock(PersonneEntityRepository.class);
        ajouter = new AjouterPersonneOutImpl(repository);
        reponse = new AjouterReponsePersonneImpl();
        servicePersonne = new AjouterServicePersonneImpl(reponse, ajouter);
    }

    @Test
    void executer_RetourneNull_Quand_ParamNull() {
        //given some preconditions (Arrange)
        given(repository.save(ArgumentMatchers.<PersonneEntity>any())).willReturn(null);
        //when an action occurs (Act)
        PersonneDto resultat = servicePersonne.executer(null);
        //then verify the output (Assert)
        BDDAssertions.then(resultat).isNull();
        BDDMockito.then(repository)
                .should(times(1))
                .save(ArgumentMatchers.<PersonneEntity>any());

    }



    @Test
    void executer_RetourneUnePersonneAvecID_Quand_ParamEstUnePersonne() {
        String nom = "Blanc";
        String id = UUID.randomUUID().toString();
        String prenom = "Sibyla";
        LocalDate dateNaissance = LocalDate.of(1996, 10, 8);

        PersonneDto personneDto = PersonneDtoBuilder.builder().nom(nom).prenom(prenom).dateNaissance(dateNaissance).adresses(Collections.emptySet()).build();

        PersonneEntity personneEntity = PersonneEntityBuilder.builder().id(id).nom(nom).prenom(prenom).dateNaissance(dateNaissance).adresses(Collections.emptySet()).build();

        given(repository.save(ArgumentMatchers.<PersonneEntity>any())).willReturn(personneEntity);
        PersonneDto resultat = servicePersonne.executer(personneDto);
        BDDAssertions.then(resultat).isNotNull();
        BDDAssertions.then(resultat.getId()).isNotNull().hasToString(id);
    }
}

