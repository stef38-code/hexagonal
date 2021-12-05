package org.stephane.domain.mock.in.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.personne.Modifier;
import org.stephane.domain.port.out.personne.Supprimer;

public class MockSupprimerPersonne implements Supprimer {

    @Override
    public String execute(Personne personne) {
        return personne.getId();
    }

    @Override
    public String execute(String idPersonne) {
        return idPersonne;
    }
}
