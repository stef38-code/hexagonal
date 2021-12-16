package org.stephane.output.entities;

import org.stephane.domain.entities.builder.Builder;
import org.stephane.domain.entities.builder.ErreursValidations;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PersonneEntityBuilder extends ErreursValidations implements Builder<PersonneEntity> {
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Set<AdresseEntity> adresses = new HashSet<>();

    private PersonneEntityBuilder() {
    }

    public static PersonneEntityBuilder aPersonne() {
        return new PersonneEntityBuilder();
    }

    public PersonneEntityBuilder clone(PersonneEntity personne) {
        this.id = personne.getId();
        this.nom = personne.getNom();
        this.prenom = personne.getPrenom();
        this.dateNaissance = personne.getDateNaissance();
        this.adresses = personne.getAdresses();
        return this;
    }

    public PersonneEntity build() {
        PersonneEntity personne = new PersonneEntity();
        personne.setId(this.id);
        personne.setNom(this.nom);
        personne.setPrenom(this.prenom);
        personne.setDateNaissance(this.dateNaissance);
        personne.setAdresses(this.adresses);
        return personne;
    }

    public PersonneEntityBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PersonneEntityBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    public PersonneEntityBuilder prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public PersonneEntityBuilder dateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }

    public PersonneEntityBuilder adresses(Set<AdresseEntity> adresses) {
        this.adresses = adresses;
        return this;
    }

}
