package org.stephane.tools;

import lombok.extern.slf4j.Slf4j;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.dto.PersonneDtoBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class GenererPersonne extends ReadFile{
    private Random rand;
    private String fileAnimaux = "src/main/resources/animaux.txt";
    private String fileAdjectif = "src/main/resources/adjectif.txt";
    private List<String> animaux;
    private List<String> adjectifs;

    public GenererPersonne() {
        rand = getSecureRandom();
        animaux = read(fileAnimaux);
        adjectifs = read(fileAdjectif);
    }

    public List<PersonneDto> genereListPersonneDto(int nombre, LocalDate startDate, LocalDate endDate) {
        List<PersonneDto> liste = new ArrayList<>();
        for (int i = 0; i < nombre; i++) {
            liste.add(generePersonneDto(startDate, endDate));
        }
        return liste;
    }

    public PersonneDto generePersonneDto(LocalDate startDate, LocalDate endDate) {
        String animal = getAnimal(animaux);
        String adjectif = getAdlectif(adjectifs);
        LocalDate dateNaissance = randomLocalDate(startDate, endDate);

        PersonneDto personneDto = PersonneDtoBuilder
                .builder()
                .prenom(animal)
                .nom(adjectif)
                .dateNaissance(dateNaissance)
                .build();

        log.info(personneDto.toString());
        return personneDto;
    }

    private String getAnimal(List<String> animaux) {
        return animaux.get(rand.nextInt(animaux.size()));
    }

    private String getAdlectif(List<String> adjectifs) {
        return adjectifs.get(rand.nextInt(adjectifs.size()));
    }


    private LocalDate randomLocalDate(LocalDate startDate, LocalDate endDate) {

        long start = startDate.toEpochDay();
        long end = endDate.toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        return Instant.ofEpochMilli(randomEpochDay).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
