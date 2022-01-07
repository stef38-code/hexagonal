package org.stephane.in.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.stephane.in.dto.PersonneDto;
import org.stephane.tools.FileTools;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonneControllerIntegrationTest extends ControllerIntegrationTest {
    @Autowired
    private PersonneController personneController;

    @Test
    @Order(1)
    void lister_Attend_LaListeDesPersonnesEnBase() throws Exception{
        //Conditions préalables (given)

        //Une action se produit (when)
        ResultActions actualPerformResult = getResult(MockMvcRequestBuilders.get("/personnes")
                .contentType(MediaType.APPLICATION_JSON), this.personneController);
        //Vérifier la sortie (then)
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
        String contentAsString = getContent(actualPerformResult);
        then(contentAsString).isNotBlank();
        Optional<List<PersonneDto>> resultat = toObjectList(contentAsString, PersonneDto.class);
        then(resultat).isPresent();
        List<PersonneDto> personneDtos = resultat.get();
        assertThat(personneDtos).hasSize(10);
    }

    @Test
    @Order(2)
    void enregistrer_Retourne_UnePersonne_Quand_Ajout_UnePersonne() throws Exception {
        String content = getJsonStringWithFile("personne.json");
        ResultActions actualPerformResult = getResult(MockMvcRequestBuilders.post("/personnes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content), this.personneController);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
        String contentAsString = getContent(actualPerformResult);
        then(contentAsString).isNotBlank();
        Optional<PersonneDto> resultat = toObject(contentAsString, PersonneDto.class);
        then(resultat).isPresent();
        PersonneDto personneDto = resultat.get();
        then(personneDto.getId()).isNotEmpty();
    }



    @Test
    @Order(3)
    void enregistrer_Retourne_400_Quand_Ajout_UnePersonneNonValide() throws Exception {
        String content = getJsonStringWithFile("personne_error.json");
        ResultActions actualPerformResult = getResult(MockMvcRequestBuilders.post("/personnes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content), this.personneController);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
        String contentAsString = getContent(actualPerformResult);

        then(contentAsString).isEmpty();

    }

}

