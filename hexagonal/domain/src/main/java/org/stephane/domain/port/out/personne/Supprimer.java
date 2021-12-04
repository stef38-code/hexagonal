package org.stephane.domain.port.out.personne;

import org.stephane.domain.entities.Personne;

public interface Supprimer {
    void execute(Personne personne);
    void execute(String id);
}
