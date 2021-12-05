package org.stephane.domain.port.out.personne;

import org.stephane.domain.entities.Personne;

public interface Supprimer {
    String execute(Personne personne);
    String execute(String id);
}
