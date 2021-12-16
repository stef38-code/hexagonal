package org.stephane.domain.business;

import org.stephane.domain.port.in.SupprimerReponse;
import org.stephane.domain.port.out.Supprimer;

public abstract class UseCaseSupprimer<D> {
    public void executer(D domaine, Supprimer<D> supprimer, SupprimerReponse reponse) {
        boolean isSupprime = supprimer.execute(domaine);
        reponse.donner(isSupprime);
    }

    public void executer(String idPersonne, Supprimer<D> supprimer, SupprimerReponse reponse) {
        boolean isSupprime = supprimer.execute(idPersonne);
        reponse.donner(isSupprime);
    }
}
