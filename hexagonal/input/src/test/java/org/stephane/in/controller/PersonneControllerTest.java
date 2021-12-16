package org.stephane.in.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.service.personne.AjouterServicePersonne;
import org.stephane.in.service.personne.AjouterServicePersonneImpl;
import tools.FileTools;
import tools.JsonTools;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {PersonneController.class})
@ExtendWith(SpringExtension.class)
class PersonneControllerTest {
    @MockBean
    private AjouterServicePersonne ajouterService;

    @Autowired
    private PersonneController personneController;

    @Test
    void enregistrer_statusOk() throws Exception {
        String content = FileTools.getResourceFileAsString("personne.json");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/personnes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.personneController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void enregistrer_statusKo() throws Exception {
        String content = FileTools.getResourceFileAsString("personne_error.json");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/personnes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.personneController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void enregistrer_Retourne_UnePersonne_Quand_Ajout_UnePersonne() {
        //Mock
        AjouterServicePersonne ajouterService = mock(AjouterServicePersonneImpl.class);
        //Instance du controler
        PersonneController controller = new PersonneController(ajouterService);
        //obj retouné par le mock
        PersonneDto personneDto = new PersonneDto();
        personneDto = JsonTools.readObjectToJsonFile(personneDto, "personne.json");
        //
        when(ajouterService.executer(ArgumentMatchers.<PersonneDto>any())).thenReturn(personneDto);
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

