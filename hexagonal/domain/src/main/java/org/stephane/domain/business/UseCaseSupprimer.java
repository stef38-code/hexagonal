package org.stephane.domain.business;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.SupprimerReponse;
import org.stephane.domain.port.out.Supprimer;

public abstract class UseCaseSupprimer<DOM> {
    public void executer(DOM domaine, Supprimer<DOM> supprimer, SupprimerReponse<DOM> reponse) {
        boolean isSupprime = supprimer.execute(domaine);
        reponse.donner(isSupprime);
    }

    public void executer(String idPersonne, Supprimer<Personne> supprimer, SupprimerReponse<Personne> reponse) {
        boolean isSupprime = supprimer.execute(idPersonne);
        reponse.donner(isSupprime);
    }
}
