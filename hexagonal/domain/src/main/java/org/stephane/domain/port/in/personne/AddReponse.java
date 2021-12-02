package org.stephane.domain.port.in.personne;

import org.stephane.domain.entities.Personne;

public interface AddReponse {
    void execute(Personne resultat);
}
