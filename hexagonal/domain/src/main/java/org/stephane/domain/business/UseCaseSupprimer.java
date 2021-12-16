package org.stephane.domain.business;

import org.stephane.domain.port.in.SupprimerReponse;
import org.stephane.domain.port.out.SupprimerOut;
/**
 * Cas d'usage pour suppression d'un element du domain
 * @param <D> element du domain contenue dans org.stephane.domain.entities
 */
public abstract class UseCaseSupprimer<D> {
    /**
     * Execution de la suppression depuis un l'element
     * @param domaine entite du domain
     * @param supprimerOut element output
     * @param reponse la réponse suite à la suppression
     */
    public void executer(D domaine, SupprimerOut<D> supprimerOut, SupprimerReponse reponse) {
        boolean isSupprime = supprimerOut.execute(domaine);
        reponse.donner(isSupprime);
    }
    /**
     * Execution de la suppression depuis un identifiant d'element
     * @param idPersonne identifiant d'une entite du domain
     * @param supprimerOut element output
     * @param reponse la réponse suite à la suppression
     */
    public void executer(String idPersonne, SupprimerOut<D> supprimerOut, SupprimerReponse reponse) {
        boolean isSupprime = supprimerOut.execute(idPersonne);
        reponse.donner(isSupprime);
    }
}
