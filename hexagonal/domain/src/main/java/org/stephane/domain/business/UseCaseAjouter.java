package org.stephane.domain.business;

import org.stephane.domain.port.in.AjouterReponse;
import org.stephane.domain.port.out.Ajouter;

public abstract class UseCaseAjouter<DOM> {

    public void executer(DOM domain, Ajouter<DOM> ajouter, AjouterReponse<DOM> reponse){
        DOM dom = ajouter.execute(domain);
        reponse.donner(dom);
    }
}
