package org.stephane.domain.business;

import org.junit.jupiter.api.Test;
import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.out.personne.Save;

import static org.junit.jupiter.api.Assertions.*;

class PersonneBusinessTest {


    @Test
    void ajouterUnePersonne() {
    }

    @Test
    void modifierUnePersonne() {
    }

    @Test
    void supprimerUnePersonne() {
    }

    @Test
    void testSupprimerUnePersonne() {
    }

    private class MockSavePersonne implements Save{

        @Override
        public Personne execute(Personne personne) {
            return null;
        }
    }
}
