package org.stephane.domain.business;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterReponse;
import org.stephane.domain.port.in.personne.DeleteReponse;
import org.stephane.domain.port.out.personne.Delete;
import org.stephane.domain.port.out.personne.Enregistrer;

public class UseCasePersonne {

    public void ajouter(Personne personne, Enregistrer enregistrer, AjouterReponse reponse){
        Personne resultat = enregistrer.execute(personne);
        reponse.donner(resultat);
    }
    public void modifierUnePersonne(Personne personne, Enregistrer enregistrer, AjouterReponse reponse){
        Personne resultat = enregistrer.execute(personne);
        reponse.donner(resultat);
    }
    public void supprimerUnePersonne(Personne personne, Delete delete, DeleteReponse reponse){
        delete.execute(personne);
        reponse.donner(personne);
    }
    public void supprimerUnePersonne(String idPersonne, Delete delete, DeleteReponse reponse){
        delete.execute(idPersonne);
        reponse.donner(idPersonne);
    }

}
