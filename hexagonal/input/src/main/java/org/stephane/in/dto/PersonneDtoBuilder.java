package org.stephane.in.dto;

import org.stephane.in.dto.builder.Builder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PersonneDtoBuilder implements Builder<PersonneDto> {
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Set<AdresseDto> adresses = new HashSet<>();

    private PersonneDtoBuilder() {
    }

    public static PersonneDtoBuilder builder() {
        return new PersonneDtoBuilder();
    }

    public PersonneDtoBuilder clone(PersonneDto personne) {
        this.id = personne.getId();
        this.nom = personne.getNom();
        this.prenom = personne.getPrenom();
        this.dateNaissance = personne.getDateNaissance();
        this.adresses = personne.getAdresses();
        return this;
    }

    public PersonneDto build() {
        PersonneDto personne = new PersonneDto();
        personne.setId(this.id);
        personne.setNom(this.nom);
        personne.setPrenom(this.prenom);
        personne.setDateNaissance(this.dateNaissance);
        personne.setAdresses(this.adresses);
        return personne;
    }

    public PersonneDtoBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PersonneDtoBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    public PersonneDtoBuilder prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public PersonneDtoBuilder dateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }

    public PersonneDtoBuilder adresses(Set<AdresseDto> adresses) {
        this.adresses = adresses;
        return this;
    }


}
