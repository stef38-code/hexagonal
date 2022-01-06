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
import org.stephane.tools.JsonMapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


class PersonneControllerTest {
    //obj retouné par le mock
    PersonneDto personneDto;
    List<PersonneDto> listPersonneDto;
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
        Optional<PersonneDto> fileContent = JsonMapper.fileToObject(PersonneDto.class, "personne.json");
        assertThat(fileContent).isPresent();
        personneDto = fileContent.get();
        //
        given(ajouterService.executer(ArgumentMatchers.<PersonneDto>any())).willReturn(this.personneDto);
        //
        ResponseEntity<PersonneDto> responseEntity = controller.enregistrer(this.personneDto);
        //controle
        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PersonneDto body = responseEntity.getBody();
        assertThat(body).isNotNull();
        //compare les obj
        assertThat(body).usingRecursiveComparison().isEqualTo(this.personneDto);

    }

    @Test
    void lister_Retourne_laListeDesPersonnes() {
        Optional<List<PersonneDto>> fileContent = JsonMapper.fileToListObject(PersonneDto.class, "personnes.json");
        assertThat(fileContent).isPresent();
        listPersonneDto = fileContent.get();
        //
        given(selectionnerService.executer()).willReturn(listPersonneDto);
        //
        ResponseEntity<Collection<PersonneDto>> responseEntity = controller.lister();
        //controle
        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Collection<PersonneDto> body = responseEntity.getBody();
        then(body).isNotNull().isNotEmpty().hasSize(10);
    }

    @Test
    void editer_Lorsque_passeUnId_Attend_unePersonne() {
        //Conditions préalables (given)
        String idPersonne = "b4af4660-fef6-4727-bc6f-504cacfd282c";
        Optional<List<PersonneDto>> fileContent = JsonMapper.fileToListObject(PersonneDto.class, "personnes.json");
        assertThat(fileContent).isPresent();
        listPersonneDto = fileContent.get();
        PersonneDto personne = listPersonneDto.stream()
                .filter(customer -> idPersonne.equals(customer.getId()))
                .findAny()
                .orElse(null);

        given(selectionnerService.executer(ArgumentMatchers.anyString())).willReturn(personne);
        //Une action se produit (when)
        ResponseEntity<PersonneDto> responseEntity = controller.editer(idPersonne);
        //Vérifier la sortie (then)
        then(personne).isNotNull();
        then(responseEntity).isNotNull();
        then(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        PersonneDto body = responseEntity.getBody();
        then(body).isNotNull();
        then(body.getId()).hasToString(idPersonne);
        then(body.getNom()).hasToString("brillant");
        then(body.getPrenom()).hasToString("Souris");
        then(body.getAdresses()).hasSize(1);
    }


}

