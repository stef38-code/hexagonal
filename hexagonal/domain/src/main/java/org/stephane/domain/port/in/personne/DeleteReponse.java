package org.stephane.domain.port.in.personne;

import org.stephane.domain.entities.Personne;

public interface DeleteReponse {
    void execute(Personne resultat);
    void execute(String idPersonne);
}
