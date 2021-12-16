package org.stephane.in.service.personne;

import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterReponsePersonne;

@Component
public class AjouterReponsePersonneImpl extends AjouterReponsePersonne {
    @Override
    public void donner(Personne resultat) {

    }

    @Override
    public Personne recuperer() {
        return null;
    }
}
