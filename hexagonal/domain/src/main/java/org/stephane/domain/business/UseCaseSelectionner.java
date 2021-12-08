package org.stephane.domain.business;

import org.stephane.domain.port.in.SelectionnerReponse;
import org.stephane.domain.port.out.Selectionner;

import java.util.List;

public abstract class UseCaseSelectionner<DOM> {
    public void executer(String id, Selectionner<DOM> selection, SelectionnerReponse<DOM> reponse){
        DOM dom = selection.executer(id);
        reponse.donnee(dom);
    }

    public void executer(Selectionner<DOM> selection, SelectionnerReponse<DOM> reponse){
        List<DOM> doms = selection.executer();
        reponse.donnees(doms);
    }
}
