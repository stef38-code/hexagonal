package org.stephane.domain.business;

import org.stephane.domain.port.in.ModifierReponse;
import org.stephane.domain.port.out.Modifier;

public abstract class UseCaseModifier<D> {
    public void executer(D domain, Modifier<D> modifier, ModifierReponse<D> reponse) {
        D resultat = modifier.execute(domain);
        reponse.donner(resultat);
    }
}
