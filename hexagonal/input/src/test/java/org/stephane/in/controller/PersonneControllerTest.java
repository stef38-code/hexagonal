package org.stephane.in.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.service.personne.AjouterServicePersonne;
import org.stephane.in.service.personne.AjouterServicePersonneImpl;
import org.stephane.in.service.personne.SelectionnerServicePersonne;
import org.stephane.in.service.personne.SelectionnerServicePersonneImpl;
import tools.JsonTools;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


class PersonneControllerTest {
    //obj retouné par le mock
    PersonneDto personneDto;
    private SelectionnerServicePersonne selectionnerService;
    private AjouterServicePersonne ajouterService;
    private PersonneController controller;

    @BeforeEach
    void setUp() {
        ajouterService = mock(AjouterServicePersonneImpl.class);
        selectionnerService = mock(SelectionnerServicePersonneImpl.class);
        controller = new PersonneController(ajouterService, selectionnerService);
        personneDto = new PersonneDto();
    }

    @Test
    void enregistrer_Retourne_UnePersonne_Quand_Ajout_UnePersonne() {
        personneDto = JsonTools.readObjectToJsonFile(personneDto, "personne.json");
        //
        given(ajouterService.executer(ArgumentMatchers.<PersonneDto>any())).willReturn(personneDto);
        //
        ResponseEntity<PersonneDto> responseEntity = controller.enregistrer(personneDto);
        //controle
        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PersonneDto body = responseEntity.getBody();
        assertThat(body).isNotNull();
        //compare les obj
        assertThat(body).usingRecursiveComparison().isEqualTo(personneDto);

    }
}

