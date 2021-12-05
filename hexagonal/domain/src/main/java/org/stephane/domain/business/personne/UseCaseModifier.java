package org.stephane.domain.business.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.ModifierReponse;
import org.stephane.domain.port.out.personne.Modifier;

public class UseCaseModifier {

    public void modifierUnePersonne(Personne personne, Modifier modifier, ModifierReponse reponse) {
        Personne resultat = modifier.execute(personne);
        reponse.donner(resultat);
    }
}
