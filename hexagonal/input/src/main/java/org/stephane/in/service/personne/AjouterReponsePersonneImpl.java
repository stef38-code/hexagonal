package org.stephane.in.service.personne;

import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterReponsePersonne;

@Component
public class AjouterReponsePersonneImpl extends AjouterReponsePersonne {
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
