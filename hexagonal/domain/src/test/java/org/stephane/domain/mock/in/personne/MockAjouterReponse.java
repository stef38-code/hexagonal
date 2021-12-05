package org.stephane.domain.mock.in.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterReponse;

public class MockAjouterReponse implements AjouterReponse {
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
