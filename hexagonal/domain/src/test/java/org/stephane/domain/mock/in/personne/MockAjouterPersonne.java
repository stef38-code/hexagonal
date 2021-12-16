package org.stephane.domain.mock.in.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.entities.PersonneBuilder;
import org.stephane.domain.port.out.personne.AjouterPersonne;

import java.util.UUID;

public class MockAjouterPersonne implements AjouterPersonne {
    @Override
    public Personne execute(Personne personne) {
        return PersonneBuilder.aPersonne().clone(personne).id(UUID.randomUUID().toString()).build();
    }
}
