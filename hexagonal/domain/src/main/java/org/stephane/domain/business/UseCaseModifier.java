package org.stephane.domain.business;

import org.stephane.domain.port.in.ModifierReponse;
import org.stephane.domain.port.out.Modifier;

public abstract class UseCaseModifier<DOM> {
    public void executer(DOM domain, Modifier<DOM> modifier, ModifierReponse<DOM> reponse) {
        DOM resultat = modifier.execute(domain);
        reponse.donner(resultat);
    }
}
