package org.stephane.domain.business;

import org.stephane.domain.port.in.AjouterReponse;
import org.stephane.domain.port.out.Enregistrer;

public abstract class UseCaseAjouter<DOM> {

    public void executer(DOM domain, Enregistrer<DOM> enregistrer, AjouterReponse<DOM> reponse){
        DOM dom = enregistrer.execute(domain);
        reponse.donner(dom);
    }
}
