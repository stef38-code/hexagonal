package org.stephane.domain.entities;

import org.stephane.domain.entities.builder.BuilderValidation;
import org.stephane.domain.entities.builder.ErreursValidations;
import org.stephane.domain.outils.OutilsValidation;
import org.stephane.domain.outils.ValidationException;

import java.time.LocalDate;


public class Personne {
    private final String id;
    private final String nom;
    private final String prenom;
    private final LocalDate dateNaissance;

    public Personne(Builder builder)
    {
        this.id = builder.id;
        this.nom = builder.nom;
        this.prenom = builder.prenom;
        this.dateNaissance = builder.dateNaissance;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Personne{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Builder
      */

    public static class Builder extends ErreursValidations implements BuilderValidation<Personne>  {
        private String id;
        private String nom;
        private String prenom;
        private LocalDate dateNaissance;

        public static Builder newInstance()
        {
            return new Builder();
        }

        private Builder() {}

        public Builder clone(Personne personne){
            id = personne.getId();
            nom= personne.getNom();
            prenom= personne.getPrenom();
            dateNaissance= personne.getDateNaissance();
            return this;
        }
        public Builder id(String id)
        {
            this.id = id;
            return this;
        }
        public Builder nom(String nom)
        {
            this.nom = nom;
            return this;
        }
        public Builder prenom(String prenom)
        {
            this.prenom = prenom;
            return this;
        }
        public Builder dateNaissance(LocalDate dateNaissance)
        {
            this.dateNaissance = dateNaissance;
            return this;
        }
        @Override
        public Personne build()
        {
            validate();
            return new Personne(this);
        }
        @Override
        public void validate()  {
            OutilsValidation.notNullNotEmpty("nom",this.nom,getErreurs());
            OutilsValidation.notNullNotEmpty("prenom",this.prenom,getErreurs());
            OutilsValidation.notNull("date de naissance",this.dateNaissance,getErreurs());
            if (nombreErreurs() > 0) {
                throw new ValidationException(getErreurs());
            }
        }
    }
}
