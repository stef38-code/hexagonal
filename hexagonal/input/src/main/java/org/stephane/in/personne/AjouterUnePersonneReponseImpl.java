package org.stephane.in.personne;

import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.AjouterReponse;

@Component
public class AjouterUnePersonneReponseImpl extends AjouterReponse<Personne> {
    @Override
    public void donner(Personne resultat) {

    }

    @Override
    public Personne recuperer() {
        return null;
    }
}
