package org.stephane.tools;

import lombok.extern.slf4j.Slf4j;
import org.stephane.in.dto.PersonneDto;
import org.stephane.in.dto.PersonneDtoBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GenererPersonne extends ReadFile implements GenererDonnees<PersonneDto>{

    private static final String FILE_ANIMAUX = "/animaux.txt";
    private static final String FILE_ADJECTIF = "/adjectif.txt";
    private final List<String> animaux;
    private final List<String> adjectifs;

    public GenererPersonne() {
        super();
        animaux = read(FILE_ANIMAUX);
        adjectifs = read(FILE_ADJECTIF);
    }

    public List<PersonneDto> genererListe(int nombre, LocalDate startDate, LocalDate endDate) {
        List<PersonneDto> liste = new ArrayList<>();
        for (int i = 0; i < nombre; i++) {
            liste.add(generer(startDate, endDate));
        }
        return liste;
    }

    public PersonneDto generer(LocalDate startDate, LocalDate endDate) {
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
        return animaux.get(getRand().nextInt(animaux.size()));
    }

    private String getAdlectif(List<String> adjectifs) {
        return adjectifs.get(getRand().nextInt(adjectifs.size()));
    }

    @Override
    public List<PersonneDto> genererListe(int nombre) {
        return genererListe(nombre,LocalDate.of(1945, 1, 1), LocalDate.of(2000, 12, 31));
    }

    @Override
    public PersonneDto generer() {
        return generer(LocalDate.of(1945, 1, 1), LocalDate.of(2000, 12, 31));
    }
}
