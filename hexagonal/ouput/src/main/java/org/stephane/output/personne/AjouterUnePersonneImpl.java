package org.stephane.output.personne;

import org.springframework.stereotype.Component;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.Ajouter;

@Component
public class AjouterUnePersonneImpl implements Ajouter<Personne> {
    @Override
    public Personne execute(Personne personne) {
        return null;
    }
}
