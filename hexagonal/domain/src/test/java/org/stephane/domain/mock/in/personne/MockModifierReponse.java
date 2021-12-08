package org.stephane.domain.mock.in.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.ModifierReponse;

public class MockModifierReponse implements ModifierReponse {
    private Personne resultat;

    @Override
    public void donner(Personne resultat) {
        this.resultat = resultat;
    }

    @Override
    public Personne recuperer() {
        return resultat;
    }
}
