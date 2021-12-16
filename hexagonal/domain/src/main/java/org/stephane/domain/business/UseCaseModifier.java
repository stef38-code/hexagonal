package org.stephane.domain.business;

import org.stephane.domain.port.in.ModifierReponse;
import org.stephane.domain.port.out.ModifierOut;
/**
 * Cas d'usage pour modifier un element du domain
 * @param <D> element du domain contenue dans org.stephane.domain.entities
 */
public abstract class UseCaseModifier<D> {
    /**
     * Execution de la modification de l'element
     * @param domain entite du domain
     * @param modifierOut element output
     * @param reponse la réponse suite à la modification
     */
    public void executer(D domain, ModifierOut<D> modifierOut, ModifierReponse<D> reponse) {
        D resultat = modifierOut.execute(domain);
        reponse.donner(resultat);
    }
}
