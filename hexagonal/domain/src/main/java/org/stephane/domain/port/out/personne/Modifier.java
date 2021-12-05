package org.stephane.domain.port.out.personne;

import org.stephane.domain.entities.Personne;

public interface Modifier {
    Personne execute(Personne personne);
}
