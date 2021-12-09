package org.stephane.in.personne;

import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterUnePersonneReponse;

@Component
public class AjouterUnePersonneReponseImpl implements AjouterUnePersonneReponse {
    @Override
    public void donner(Personne resultat) {

    }

    @Override
    public Personne recuperer() {
        return null;
    }
}
