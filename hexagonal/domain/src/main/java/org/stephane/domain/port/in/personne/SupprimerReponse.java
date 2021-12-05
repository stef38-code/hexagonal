package org.stephane.domain.port.in.personne;

public interface SupprimerReponse {
    void donner(String idPersonne);

    String recuperer();
}
