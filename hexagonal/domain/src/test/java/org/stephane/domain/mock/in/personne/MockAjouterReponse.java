package org.stephane.domain.mock.in.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.AjouterReponse;

public class MockAjouterReponse extends AjouterReponse<Personne> {
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
