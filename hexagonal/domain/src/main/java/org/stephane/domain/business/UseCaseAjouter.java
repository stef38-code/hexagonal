package org.stephane.domain.business;

import org.stephane.domain.port.in.AjouterReponse;
import org.stephane.domain.port.out.AjouterOut;

/**
 * Cas d'usage pour ajouter un element du domain
 * @param <D> element du domain contenue dans org.stephane.domain.entities
 */
public abstract class UseCaseAjouter<D> {
    /**
     * Execution de l'ajout de l'element
     * @param domain entite du domain
     * @param ajouterOut element output
     * @param reponse la réponse suite à l'ajout
     */
    public void executer(D domain, AjouterOut<D> ajouterOut, AjouterReponse<D> reponse){
        D dom = ajouterOut.execute(domain);
        reponse.donner(dom);
    }
}
