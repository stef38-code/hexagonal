package org.stephane.domain.entities;

import org.stephane.domain.entities.builder.Builder;
import org.stephane.domain.entities.builder.ErreursValidations;
import org.stephane.domain.entities.builder.Validation;
import org.stephane.domain.outils.OutilsValidation;
import org.stephane.domain.outils.ValidationException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PersonneBuilder extends ErreursValidations implements Builder<Personne>, Validation {
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Set<Adresse> adresses = new HashSet<>();

    private PersonneBuilder() {
    }

    public static PersonneBuilder aPersonne() {
        return new PersonneBuilder();
    }

    public PersonneBuilder clone(Personne personne) {
        this.id = personne.getId();
        this.nom = personne.getNom();
        this.prenom = personne.getPrenom();
        this.dateNaissance = personne.getDateNaissance();
        this.adresses = personne.getAdresses();
        return this;
    }

    public Personne build() {
        validate();
        Personne personne = new Personne();
        personne.setId(this.id);
        personne.setNom(this.nom);
        personne.setPrenom(this.prenom);
        personne.setDateNaissance(this.dateNaissance);
        personne.setAdresses(this.adresses);
        return personne;
    }

    public PersonneBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PersonneBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    public PersonneBuilder prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public PersonneBuilder dateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }

    public PersonneBuilder adresses(Set<Adresse> adresses) {
        this.adresses = adresses;
        return this;
    }

    @Override
    public void validate() {
        OutilsValidation.notNullNotEmpty("nom", this.nom, getErreurs());
        OutilsValidation.notNullNotEmpty("prenom", this.prenom, getErreurs());
        OutilsValidation.notNull("date de naissance", this.dateNaissance, getErreurs());
        if (nombreErreurs() > 0) {
            throw new ValidationException(getErreurs());
        }
    }
}
