package org.stephane.in.dto;

import org.stephane.in.dto.builder.Builder;

import java.util.HashSet;
import java.util.Set;

public class AdresseDtoBuilder implements Builder<AdresseDto> {
    private String id;
    private String appartementEscalierEtage;
    private String batimentResidence;
    private String numeroNomVoie;
    private String complementAdresse;
    private String codePostal;
    private String ville;
    private String pays;
    private Set<PersonneDto> personnes = new HashSet<>();

    private AdresseDtoBuilder() {
    }

    public static AdresseDtoBuilder builder() {
        return new AdresseDtoBuilder();
    }
    public AdresseDtoBuilder clone(AdresseDto adresseDto) {
        this.id = adresseDto.getId();
        this.appartementEscalierEtage = adresseDto.getAppartementEscalierEtage();
        this.batimentResidence = adresseDto.getBatimentResidence();
        this.numeroNomVoie = adresseDto.getNumeroNomVoie();
        this.complementAdresse = adresseDto.getComplementAdresse();
        this.codePostal = adresseDto.getCodePostal();
        this.ville = adresseDto.getVille();
        this.pays = adresseDto.getPays();
        this.personnes = adresseDto.getPersonnes();
        return this;
    }

    public AdresseDto build() {
        AdresseDto adresseDto = new AdresseDto();
        adresseDto.setId(this.id);
        adresseDto.setAppartementEscalierEtage(this.appartementEscalierEtage);
        adresseDto.setBatimentResidence(this.batimentResidence);
        adresseDto.setNumeroNomVoie(this.numeroNomVoie);
        adresseDto.setComplementAdresse(this.complementAdresse);
        adresseDto.setCodePostal(this.codePostal);
        adresseDto.setVille(this.ville);
        adresseDto.setPays(this.pays);
        adresseDto.setPersonnes(this.personnes);
        return adresseDto;
    }
    public AdresseDtoBuilder appartementEscalierEtage(String appartementEscalierEtage) {
        this.appartementEscalierEtage = appartementEscalierEtage;
        return this;
    }

    public AdresseDtoBuilder batimentResidence(String batimentResidence) {
        this.batimentResidence = batimentResidence;
        return this;
    }

    public AdresseDtoBuilder numeroNomVoie(String numeroNomVoie) {
        this.numeroNomVoie = numeroNomVoie;
        return this;
    }

    public AdresseDtoBuilder complementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
        return this;
    }

    public AdresseDtoBuilder codePostal(String codePostal) {
        this.codePostal = codePostal;
        return this;
    }

    public AdresseDtoBuilder ville(String ville) {
        this.ville = ville;
        return this;
    }

    public AdresseDtoBuilder pays(String pays) {
        this.pays = pays;
        return this;
    }


    public AdresseDtoBuilder personnes(Set<PersonneDto> personnes) {
        this.personnes = personnes;
        return this;
    }
}
