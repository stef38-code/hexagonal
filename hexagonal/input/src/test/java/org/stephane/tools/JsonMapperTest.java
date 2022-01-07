package org.stephane.tools;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.stephane.in.dto.PersonneDto;

import static org.assertj.core.api.Assertions.assertThat;

class JsonMapperTest {
    private final GenererPersonne genererPersonne = new GenererPersonne();
    private LocalDate startDate ;
    private LocalDate endDate ;
    private PersonneDto personneDto;
    private PersonneDto personneDto2;
    private List<PersonneDto> personneDtoList;

    private JsonMapper jsonMapper;

    @BeforeEach
    void setUp() {
        jsonMapper = new JsonMapper();
        startDate = LocalDate.of(1945, 1, 1);
        endDate = LocalDate.of(2000, 12, 31);
        personneDto = genererPersonne.generer(startDate, endDate);
        personneDto2 = genererPersonne.generer(startDate, endDate);
        personneDtoList = List.of(personneDto,personneDto2);
    }

    @Test
    void toString_UnObjet() {
        Optional<String> actualToStringResult = jsonMapper.toString(personneDto);
        assertThat(actualToStringResult).isPresent();
        assertThat(actualToStringResult.get())
                .contains(personneDto.getNom())
                .contains(personneDto.getPrenom())
                .contains(personneDto.getDateNaissance().toString());
    }
    @Test
    void toString_UneListObjet() {
        Optional<String> actualToStringResult = jsonMapper.toString(personneDtoList);
        assertThat(actualToStringResult).isPresent();
        assertThat(actualToStringResult.get())
                .contains(personneDto.getNom())
                .contains(personneDto.getPrenom())
                .contains(personneDto.getDateNaissance().toString())
                .contains(personneDto2.getNom())
                .contains(personneDto2.getPrenom())
                .contains(personneDto2.getDateNaissance().toString());
    }
    @Test
    void toObject() {
        assertThat(jsonMapper.toObject("Not all who wander are lost", Object.class)).isNotPresent();
        assertThat(jsonMapper.toObject("42", String.class)).isPresent();
        assertThat(jsonMapper.toObject("", Object.class)).isNotPresent();
        Optional<PersonneDto> actual = jsonMapper.toObject("{\"id\":null,\"nom\":\"compétent\",\"prenom\":\"Koala\",\"dateNaissance\":\"1974-08-07\",\"adresses\":[]}", PersonneDto.class);
        assertThat(actual).isPresent();
        PersonneDto dto = actual.get();
        assertThat(dto.getNom()).hasToString("compétent");
        assertThat(dto.getPrenom()).hasToString("Koala");
        assertThat(dto.getDateNaissance().toString()).hasToString("1974-08-07");
        assertThat(dto.getAdresses()).isEmpty();
    }

    @Test
    void toObjectList() {
        assertThat(jsonMapper.toObjectList("Not all who wander are lost", Object.class)).isNotPresent();
        Optional<List<PersonneDto>> resultat = jsonMapper.toObjectList("[{\"id\":null,\"nom\":\"exemplaire\",\"prenom\":\"Iguane\",\"dateNaissance\":\"1957-05-02\",\"adresses\":[]},{\"id\":null,\"nom\":\"lisse\",\"prenom\":\"Lapin\",\"dateNaissance\":\"1972-08-26\",\"adresses\":[]}]", PersonneDto.class);
        assertThat(resultat).isPresent();
        List<PersonneDto> dtoList = resultat.get();
        assertThat(dtoList).isNotEmpty().hasSize(2);
        dtoList.forEach(this::assertThatPersonneDto);
    }

    private void assertThatPersonneDto(PersonneDto personneDtoR) {
        assertThat(personneDtoR.getNom()).isNotEmpty();
        assertThat(personneDtoR.getPrenom()).isNotEmpty();
        assertThat(personneDtoR.getDateNaissance()).isNotNull();
        assertThat(personneDtoR.getAdresses()).isEmpty();
    }

    @Test
    void testObjectToFile() {
        assertThat(jsonMapper.objectToFile("Obj", "Nom Fichier")).isFalse();
    }

    @Test
    void testFileToObject() {
        assertThat(jsonMapper.fileToObject(Object.class, "Nom Fichier")).isNotPresent();
        assertThat(jsonMapper.fileToObject(Object.class, "")).isNotPresent();
    }

    @Test
    void testFileToListObject() {
        assertThat(jsonMapper.fileToListObject(Object.class, "Nom Fichier")).isNotPresent();
        assertThat(jsonMapper.fileToListObject(Object.class, "")).isNotPresent();
    }
}

