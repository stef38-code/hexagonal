package org.stephane.in.service.personne;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


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
        then(resultat).isNull();
/*        BDDMockito.then(repository)
                .should(times(1))
                .save(ArgumentMatchers.<PersonneEntity>any());*/

    }

    @Test
    void executer_RetourneUnePersonneAvecID_Quand_ParamEstUnePersonne() {
        //Conditions préalables (given)
        String nom = "Blanc";
        String id = UUID.randomUUID().toString();
        String prenom = "Sibyla";
        LocalDate dateNaissance = LocalDate.of(1996, 10, 8);

        PersonneDto personneDto = PersonneDtoBuilder.builder().nom(nom).prenom(prenom).dateNaissance(dateNaissance).adresses(Collections.emptySet()).build();

        PersonneEntity personneEntity = PersonneEntityBuilder.builder().id(id).nom(nom).prenom(prenom).dateNaissance(dateNaissance).adresses(Collections.emptySet()).build();

        given(repository.save(ArgumentMatchers.<PersonneEntity>any())).willReturn(personneEntity);
        //Une action se produit (when)
        PersonneDto resultat = servicePersonne.executer(personneDto);
        //Vérifier la sortie (then)
        then(resultat).isNotNull();
        then(resultat.getId()).isNotNull().hasToString(id);
    }
}

