package org.stephane.tools;

import lombok.extern.slf4j.Slf4j;
import org.stephane.in.dto.AdresseDto;
import org.stephane.in.dto.AdresseDtoBuilder;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class GenererAdresse extends ReadFile {
    private Random rand;
    private String fileRue = "src/main/resources/rue.txt";
    private String fileDepartement = "src/main/resources/departement.txt";
    private List<String> rues;
    private List<String> codesPostalEtVilles;

    public GenererAdresse() {
        rues = read(fileRue);
        codesPostalEtVilles = read(fileDepartement);
        rand = getSecureRandom();
    }

    public List<AdresseDto> genereListAdresseDto(int nombre) {
        List<AdresseDto> liste = new ArrayList<>();
        for (int i = 0; i < nombre; i++) {
            liste.add(genereAdresseDto());
        }
        return liste;
    }

    public AdresseDto genereAdresseDto() {
        String rue = getRue(rues);
        String codePerstalEtDepartement = getCodesPostalEtVilles(codesPostalEtVilles);
        String[] split = codePerstalEtDepartement.split(";");
        AdresseDto adresseDto = AdresseDtoBuilder.builder()
                .numeroNomVoie(rue)
                .codePostal(split[0])
                .ville(split[1])
                .build();
        log.info(adresseDto.toString());
        return adresseDto;
    }

    private String getRue(List<String> rues) {
        return rues.get(rand.nextInt(rues.size()));
    }

    private String getCodesPostalEtVilles(List<String> codePerstalEtDepartement) {
        return codePerstalEtDepartement.get(rand.nextInt(codePerstalEtDepartement.size()));
    }


}
