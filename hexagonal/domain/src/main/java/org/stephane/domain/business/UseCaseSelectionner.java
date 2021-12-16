package org.stephane.domain.business;

import org.stephane.domain.port.in.SelectionnerReponse;
import org.stephane.domain.port.out.Selectionner;

import java.util.List;

public abstract class UseCaseSelectionner<D> {
    public void executer(String id, Selectionner<D> selection, SelectionnerReponse<D> reponse){
        D dom = selection.executer(id);
        reponse.donnee(dom);
    }

    public void executer(Selectionner<D> selection, SelectionnerReponse<D> reponse){
        List<D> doms = selection.executer();
        reponse.donnees(doms);
    }
}
