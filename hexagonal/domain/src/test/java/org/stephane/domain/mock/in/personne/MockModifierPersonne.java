package org.stephane.domain.mock.in.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.personne.Enregistrer;
import org.stephane.domain.port.out.personne.Modifier;

import java.util.UUID;

public class MockModifierPersonne implements Modifier {
    @Override
    public Personne execute(Personne personne) {
        return personne;
    }
}
