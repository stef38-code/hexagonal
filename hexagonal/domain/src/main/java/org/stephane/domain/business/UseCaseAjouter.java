package org.stephane.domain.business;

import org.stephane.domain.port.in.AjouterReponse;
import org.stephane.domain.port.out.AjouterOut;

import java.util.logging.Logger;

/**
 * Cas d'usage pour ajouter un element du domain
 *
 * @param <D> element du domain contenue dans org.stephane.domain.entities
 */
public abstract class UseCaseAjouter<D> {
    private final static Logger log = Logger.getLogger(UseCaseAjouter.class.getName());

    /**
     * Execution de l'ajout de l'element
     *
     * @param domain     entite du domain
     * @param ajouterOut element output
     * @param reponse    la réponse suite à l'ajout
     */
    public void executer(D domain, AjouterOut<D> ajouterOut, AjouterReponse<D> reponse) {
        log.info("business:UseCaseAjouter:DEBUT---------------------------------------------");
        D dom = ajouterOut.execute(domain);
        log.info("business:UseCaseAjouter:REPONSE---------------------------------------------");
        reponse.donner(dom);
        log.info("business:UseCaseAjouter:FIN---------------------------------------------");
    }
}
