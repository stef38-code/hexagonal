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

    @BeforeEach
    void setUp() {
        startDate = LocalDate.of(1945, 1, 1);
        endDate = LocalDate.of(2000, 12, 31);
        personneDto = genererPersonne.generer(startDate, endDate);
        personneDto2 = genererPersonne.generer(startDate, endDate);
        personneDtoList = List.of(personneDto,personneDto2);
    }

    @Test
    void toString_UnObjet() {
        Optional<String> actualToStringResult = JsonMapper.toString(personneDto);
        assertThat(actualToStringResult).isPresent();
        assertThat(actualToStringResult.get())
                .contains(personneDto.getNom())
                .contains(personneDto.getPrenom())
                .contains(personneDto.getDateNaissance().toString());
    }
    @Test
    void toString_UneListObjet() {
        Optional<String> actualToStringResult = JsonMapper.toString(personneDtoList);
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
        assertThat(JsonMapper.toObject("Not all who wander are lost", Object.class)).isNotPresent();
        assertThat(JsonMapper.toObject("42", String.class)).isPresent();
        assertThat(JsonMapper.toObject("", Object.class)).isNotPresent();
        Optional<PersonneDto> actual = JsonMapper.toObject("{\"id\":null,\"nom\":\"compétent\",\"prenom\":\"Koala\",\"dateNaissance\":\"1974-08-07\",\"adresses\":[]}", PersonneDto.class);
        assertThat(actual).isPresent();
        PersonneDto dto = actual.get();
        assertThat(dto.getNom()).hasToString("compétent");
        assertThat(dto.getPrenom()).hasToString("Koala");
        assertThat(dto.getDateNaissance().toString()).hasToString("1974-08-07");
        assertThat(dto.getAdresses()).isEmpty();
    }

    @Test
    void toObjectList() {
        assertThat(JsonMapper.toObjectList("Not all who wander are lost", Object.class)).isNotPresent();
        Optional<List<PersonneDto>> resultat = JsonMapper.toObjectList("[{\"id\":null,\"nom\":\"exemplaire\",\"prenom\":\"Iguane\",\"dateNaissance\":\"1957-05-02\",\"adresses\":[]},{\"id\":null,\"nom\":\"lisse\",\"prenom\":\"Lapin\",\"dateNaissance\":\"1972-08-26\",\"adresses\":[]}]", PersonneDto.class);
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
        assertThat(JsonMapper.objectToFile("Obj", "Nom Fichier")).isFalse();
    }

    @Test
    void testFileToObject() {
        assertThat(JsonMapper.fileToObject(Object.class, "Nom Fichier")).isNotPresent();
        assertThat(JsonMapper.fileToObject(Object.class, "")).isNotPresent();
    }

    @Test
    void testFileToListObject() {
        assertThat(JsonMapper.fileToListObject(Object.class, "Nom Fichier")).isNotPresent();
        assertThat(JsonMapper.fileToListObject(Object.class, "")).isNotPresent();
    }
}

