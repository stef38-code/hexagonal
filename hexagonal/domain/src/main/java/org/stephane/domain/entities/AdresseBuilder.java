package org.stephane.domain.entities;

import org.stephane.domain.entities.builder.Builder;
import org.stephane.domain.entities.builder.ErreursValidations;
import org.stephane.domain.entities.builder.Validation;
import org.stephane.domain.outils.ValidationException;

import java.util.Set;

import static org.stephane.domain.outils.AdresseValidation.valideCodePostal;
import static org.stephane.domain.outils.OutilsValidation.notNullNotEmpty;

public class AdresseBuilder extends ErreursValidations implements Validation, Builder<Adresse> {
    private String id;
    private String appartementEscalierEtage;
    private String pays;
    private String batimentResidence;
    private String numeroNomVoie;
    private String complementAdresse;
    private String codePostal;
    private String ville;
    private Set<Personne> personnes;

    public static AdresseBuilder aAdresse() {
        return new AdresseBuilder();
    }

    public AdresseBuilder clone(Adresse adresse) {
        id = adresse.getId();
        this.appartementEscalierEtage = adresse.getAppartementEscalierEtage();
        this.batimentResidence = adresse.getBatimentResidence();
        this.numeroNomVoie = adresse.getNumeroNomVoie();
        this.complementAdresse = adresse.getComplementAdresse();
        this.codePostal = adresse.getCodePostal();
        this.ville = adresse.getVille();
        this.pays = adresse.getPays();
        this.personnes = adresse.getPersonnes();
        return this;
    }

    public AdresseBuilder id(String id) {
        this.id = id;
        return this;
    }

    public AdresseBuilder appartementEscalierEtage(String appartementEscalierEtage) {
        this.appartementEscalierEtage = appartementEscalierEtage;
        return this;
    }

    public AdresseBuilder pays(String pays) {
        this.pays = pays;
        return this;
    }

    public AdresseBuilder personnes(Set<Personne> personnes) {
        this.personnes = personnes;
        return this;
    }

    public AdresseBuilder batimentResidence(String batimentResidence) {
        this.batimentResidence = batimentResidence;
        return this;
    }

    public AdresseBuilder numeroNomVoie(String numeroNomVoie) {
        this.numeroNomVoie = numeroNomVoie;
        return this;
    }

    public AdresseBuilder complementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
        return this;
    }

    public AdresseBuilder codePostal(String codePostal) {
        this.codePostal = codePostal;
        return this;
    }

    public AdresseBuilder ville(String ville) {
        this.ville = ville;
        return this;
    }

    public Adresse build() {
        validate();
        Adresse adresse = new Adresse();
        adresse.setId(this.id);
        adresse.setAppartementEscalierEtage(appartementEscalierEtage);
        adresse.setBatimentResidence(batimentResidence);
        adresse.setNumeroNomVoie(numeroNomVoie);
        adresse.setComplementAdresse(complementAdresse);
        adresse.setCodePostal(codePostal);
        adresse.setVille(ville);
        adresse.setPays(pays);
        adresse.setPersonnes(personnes);
        return adresse;
    }

    @Override
    public void validate() throws IllegalStateException {
        notNullNotEmpty("le numéro && nom voie", this.numeroNomVoie, getErreurs());
        notNullNotEmpty("la ville", this.ville, getErreurs());
        notNullNotEmpty("le pays", this.pays, getErreurs());
        valideCodePostal("le code postal", this.codePostal, getErreurs());
        if (nombreErreurs() > 0) {
            throw new ValidationException(getErreurs());
        }
    }
}
