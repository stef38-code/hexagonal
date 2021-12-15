package org.stephane.output.personne;

import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.Enregistrer;

@Component
public class EnregistrerUnePersonneImpl extends Enregistrer<Personne> {
    @Override
    public Personne execute(Personne personne) {
        return null;
    }
}
