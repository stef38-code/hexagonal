package org.stephane.domain.business.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.SupprimerReponse;
import org.stephane.domain.port.out.personne.Supprimer;

public class UseCaseSupprimer {

    public void supprimerUnePersonne(Personne personne, Supprimer supprimer, SupprimerReponse reponse){
        supprimer.execute(personne);
        reponse.donner(personne.getId());
    }
    public void supprimerUnePersonne(String idPersonne, Supprimer supprimer, SupprimerReponse reponse){
        supprimer.execute(idPersonne);
        reponse.donner(idPersonne);
    }

}
