package org.stephane.domain.business;

import org.stephane.domain.port.in.AjouterReponse;
import org.stephane.domain.port.out.Ajouter;

public abstract class UseCaseAjouter<D> {

    public void executer(D domain, Ajouter<D> ajouter, AjouterReponse<D> reponse){
        D dom = ajouter.execute(domain);
        reponse.donner(dom);
    }
}
