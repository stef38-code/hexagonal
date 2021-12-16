package org.stephane.domain.mock.in.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.ModifierOut;

public class MockModifierPersonneOut implements ModifierOut<Personne> {
    @Override
    public Personne execute(Personne personne) {
        return personne;
    }
}
