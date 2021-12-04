package org.stephane.domain.entities;

public class Adresse {
    private final String id;
    private final String appartementEscalierEtage;
    private final String batimentResidence;
    private final String numeroNomVoie;
    private final String  complementAdresse;
    private final String  codePostal;
    private final String  ville;
    private final String  pays;
    public Adresse(Adresse.Builder builder){
        this.id = builder.id;
        this.appartementEscalierEtage=builder.appartementEscalierEtage;
        this.batimentResidence=builder.batimentResidence;
        this.numeroNomVoie=builder.numeroNomVoie;
        this.complementAdresse=builder.complementAdresse;
        this.codePostal=builder.codePostal;
        this.ville=builder.ville;
        this.pays=builder.pays;
    }

    public String getId() {
        return id;
    }

    public String getAppartementEscalierEtage() {
        return appartementEscalierEtage;
    }

    public String getBatimentResidence() {
        return batimentResidence;
    }

    public String getNumeroNomVoie() {
        return numeroNomVoie;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
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
        sb.append('}');
        return sb.toString();
    }

    /**
     *
     */
    public static class Builder {

        public String id;
        public String appartementEscalierEtage;
        public String pays;
        public String batimentResidence;
        public String numeroNomVoie;
        public String complementAdresse;
        public String codePostal;
        public String ville;
        public static Adresse.Builder newInstance()
        {
            return new Adresse.Builder();
        }

        private Builder() {}

        public Adresse.Builder clone(Adresse adresse){
            id = adresse.getId();
            this.appartementEscalierEtage=adresse.getAppartementEscalierEtage();
            this.batimentResidence=adresse.getBatimentResidence();
            this.numeroNomVoie=adresse.getNumeroNomVoie();
            this.complementAdresse=adresse.getComplementAdresse();
            this.codePostal=adresse.getCodePostal();
            this.ville=adresse.getVille();
            this.pays=adresse.getPays();
            return this;
        }

        public Adresse.Builder id(String id) {
            this.id = id;
            return this;
        }

        public Adresse.Builder appartementEscalierEtage(String appartementEscalierEtage) {
            this.appartementEscalierEtage = appartementEscalierEtage;
            return this;
        }

        public Adresse.Builder pays(String pays) {
            this.pays = pays;
            return this;
        }

        public Adresse.Builder batimentResidence(String batimentResidence) {
            this.batimentResidence = batimentResidence;
            return this;
        }

        public Adresse.Builder numeroNomVoie(String numeroNomVoie) {
            this.numeroNomVoie = numeroNomVoie;
            return this;
        }

        public Adresse.Builder getComplementAdresse(String complementAdresse) {
            this.complementAdresse=complementAdresse;
            return this;
        }

        public Adresse.Builder codePostal(String codePostal) {
            this.codePostal=codePostal;
            return this;
        }

        public Adresse.Builder ville(String ville) {
            this. ville=ville;
            return this;
        }
    }
}
