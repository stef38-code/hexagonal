package org.stephane.domain.mock.in.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.Modifier;

public class MockModifierPersonne extends Modifier<Personne> {
    @Override
    public Personne execute(Personne personne) {
        return personne;
    }
}
