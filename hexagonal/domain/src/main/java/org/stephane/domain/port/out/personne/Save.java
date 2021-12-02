package org.stephane.domain.port.out.personne;

import org.stephane.domain.entities.Personne;

public interface Save {
    Personne execute(Personne personne);
}
