package org.stephane.in.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.service.AjouterUnePersonneService;
import tools.FileTools;
import tools.JsonTools;

import java.time.LocalDate;

@ContextConfiguration(classes = {PersonneController.class})
@ExtendWith(SpringExtension.class)
class PersonneControllerTest {
    @MockBean
    private AjouterUnePersonneService ajouterUnePersonneService;

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
}

