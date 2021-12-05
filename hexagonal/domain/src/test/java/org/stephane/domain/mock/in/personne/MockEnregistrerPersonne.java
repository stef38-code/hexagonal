package org.stephane.domain.mock.in.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.personne.Enregistrer;

import java.util.UUID;

public class MockEnregistrerPersonne implements Enregistrer {
    @Override
    public Personne execute(Personne personne) {
        return Personne.Builder.newInstance().clone(personne).id(UUID.randomUUID().toString()).build();
    }
}
