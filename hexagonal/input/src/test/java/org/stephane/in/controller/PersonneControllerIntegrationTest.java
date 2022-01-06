package org.stephane.in.controller;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.stephane.in.dto.PersonneDto;
import org.stephane.tools.FileTools;
import org.stephane.tools.JsonMapper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
class PersonneControllerIntegrationTest {
    @Autowired
    private PersonneController personneController;

    @Test
    @Order(1)
    void enregistrer_Retourne_UnePersonne_Quand_Ajout_UnePersonne() throws Exception {
        Optional<String> value = FileTools.getResourceFileAsString("personne.json");

        assertThat(value).isPresent();
        String content = value.get();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/personnes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.personneController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
        String contentAsString = actualPerformResult.andReturn().getResponse().getContentAsString();
        then(contentAsString).isNotBlank();
        Optional<PersonneDto> resultat = JsonMapper.toObject(contentAsString, PersonneDto.class);
        then(resultat).isPresent();
        PersonneDto personneDto = resultat.get();
        then(personneDto.getId()).isNotEmpty();
    }

    @Test
    @Order(2)
    void enregistrer_Retourne_400_Quand_Ajout_UnePersonneNonValide() throws Exception {
        Optional<String> value = FileTools.getResourceFileAsString("personne_error.json");
        then(value).isPresent();
        String content = value.get();

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/personnes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.personneController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
        String contentAsString = actualPerformResult.andReturn().getResponse().getContentAsString();

        then(contentAsString).isEmpty();

    }

    @Test
    @Order(3)
    void lister_Attend_LaListeDesPersonnesEnBase() throws Exception{
        //Conditions préalables (given)

        //Une action se produit (when)
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/personnes")
                .contentType(MediaType.APPLICATION_JSON);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.personneController)
                .build()
                .perform(requestBuilder);
        //Vérifier la sortie (then)
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
        String contentAsString = actualPerformResult.andReturn().getResponse().getContentAsString();
        then(contentAsString).isNotBlank();
        Optional<List<PersonneDto>> resultat = JsonMapper.toObjectList(contentAsString, PersonneDto.class);
        then(resultat).isPresent();
        List<PersonneDto> personneDtos = resultat.get();
        assertThat(personneDtos).hasSize(10);
    }

}

