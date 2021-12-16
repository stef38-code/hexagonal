package org.stephane.domain.business;

import org.stephane.domain.port.in.SelectionnerReponse;
import org.stephane.domain.port.out.SelectionnerOut;

import java.util.List;

/**
 * Cas d'usage pour selectionner un element ou tous les elements du domain
 * @param <D> element du domain contenue dans org.stephane.domain.entities
 */
public abstract class UseCaseSelectionner<D> {
    /**
     * Execution de la selection d'un element depuis un id
     * @param id identifiant
     * @param selection element output
     * @param reponse la réponse suite à selection
     */
    public void executer(String id, SelectionnerOut<D> selection, SelectionnerReponse<D> reponse){
        D dom = selection.executer(id);
        reponse.donnee(dom);
    }

    /**
     * Execution de la selection de tout les elements
     * @param selection element output
     * @param reponse la réponse suite à selection
     */
    public void executer(SelectionnerOut<D> selection, SelectionnerReponse<D> reponse){
        List<D> doms = selection.executer();
        reponse.donnees(doms);
    }
}
