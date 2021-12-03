package org.stephane.domain.port.in.personne;

import org.stephane.domain.entities.Personne;

public interface DeleteReponse {
    void donner(Personne resultat);
    void donner(String idPersonne);
}
