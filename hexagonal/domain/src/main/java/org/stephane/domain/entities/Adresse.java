package org.stephane.domain.entities;

import java.util.Set;

public class Adresse {
    private String id;
    private String appartementEscalierEtage;
    private String batimentResidence;
    private String numeroNomVoie;
    private String complementAdresse;
    private String codePostal;
    private String ville;
    private String pays;
    private Set<Personne> personnes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppartementEscalierEtage() {
        return appartementEscalierEtage;
    }

    public void setAppartementEscalierEtage(String appartementEscalierEtage) {
        this.appartementEscalierEtage = appartementEscalierEtage;
    }

    public String getBatimentResidence() {
        return batimentResidence;
    }

    public void setBatimentResidence(String batimentResidence) {
        this.batimentResidence = batimentResidence;
    }

    public String getNumeroNomVoie() {
        return numeroNomVoie;
    }

    public void setNumeroNomVoie(String numeroNomVoie) {
        this.numeroNomVoie = numeroNomVoie;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Set<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(Set<Personne> personnes) {
        this.personnes = personnes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adresse{");
        sb.append("id='").append(id).append('\'');
        sb.append(", appartementEscalierEtage='").append(appartementEscalierEtage).append('\'');
        sb.append(", batimentResidence='").append(batimentResidence).append('\'');
        sb.append(", numeroNomVoie='").append(numeroNomVoie).append('\'');
        sb.append(", complementAdresse='").append(complementAdresse).append('\'');
        sb.append(", codePostal='").append(codePostal).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append(", pays='").append(pays).append('\'');
        sb.append(", personnes=").append(personnes);
        sb.append('}');
        return sb.toString();
    }


}
