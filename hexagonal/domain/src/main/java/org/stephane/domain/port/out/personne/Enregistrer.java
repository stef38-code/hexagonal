package org.stephane.domain.port.out.personne;

import org.stephane.domain.entities.Personne;

public interface Enregistrer {
    Personne execute(Personne personne);
}
