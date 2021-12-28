package org.stephane.tools;

import lombok.extern.slf4j.Slf4j;
import org.stephane.in.dto.AdresseDto;
import org.stephane.in.dto.AdresseDtoBuilder;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GenererAdresse extends ReadFile implements GenererDonnees<AdresseDto>{
    private static  final String FILE_RUE = "/rue.txt";
    private static final String FILE_DEPARTEMENT = "/departement.txt";
    private final List<String> rues;
    private final List<String> codesPostalEtVilles;

    public GenererAdresse() {
        super();
        rues = read(FILE_RUE);
        codesPostalEtVilles = read(FILE_DEPARTEMENT);
    }
@Override
    public List<AdresseDto> genererListe(int nombre) {
        List<AdresseDto> liste = new ArrayList<>();
        for (int i = 0; i < nombre; i++) {
            liste.add(generer());
        }
        return liste;
    }

    public AdresseDto generer() {
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
        return rues.get(getRand().nextInt(rues.size()));
    }

    private String getCodesPostalEtVilles(List<String> codePerstalEtDepartement) {
        return codePerstalEtDepartement.get(getRand().nextInt(codePerstalEtDepartement.size()));
    }


}
