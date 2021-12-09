package org.stephane.output.personne;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.personne.Enregistrer;

@Component
public class EnregistrerUnePersonneImpl implements Enregistrer {
    @Override
    public Personne execute(Personne personne) {
        return null;
    }
}
