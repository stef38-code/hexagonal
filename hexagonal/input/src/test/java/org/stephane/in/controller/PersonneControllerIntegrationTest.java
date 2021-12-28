package org.stephane.in.controller;

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
import tools.FileTools;
import tools.JsonTools;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonneControllerIntegrationTest {
    @Autowired
    private PersonneController personneController;

    @Test
    void enregistrer_Retourne_UnePersonne_Quand_Ajout_UnePersonne() throws Exception {
        String content = FileTools.getResourceFileAsString("personne.json");
        assert content != null;
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/personnes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.personneController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
        String contentAsString = actualPerformResult.andReturn().getResponse().getContentAsString();
        assertThat(contentAsString).isNotBlank();
        PersonneDto personneDto = JsonTools.parseJsonStringToObject(contentAsString, PersonneDto.class);
        assertThat(personneDto.getId()).isNotEmpty();
    }

    @Test
    void enregistrer_Retourne_400_Quand_Ajout_UnePersonneNonValide() throws Exception {
        String content = FileTools.getResourceFileAsString("personne_error.json");
        assert content != null;
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/personnes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.personneController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
        String contentAsString = actualPerformResult.andReturn().getResponse().getContentAsString();

        assertThat(contentAsString).isEmpty();

    }

}

