package org.stephane.in.service.personne;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.AjouterReponse;

@Component
@Qualifier("AjouterReponsePersonne")
public class AjouterReponseImpl extends AjouterReponse<Personne> {
    @Override
    public void donner(Personne resultat) {

    }

    @Override
    public Personne recuperer() {
        return null;
    }
}
