package org.stephane.domain.business;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AddReponse;
import org.stephane.domain.port.in.personne.DeleteReponse;
import org.stephane.domain.port.out.personne.Delete;
import org.stephane.domain.port.out.personne.Save;

public class PersonneBusiness {

    public void ajouterUnePersonne(Personne personne, Save save,AddReponse reponse){
        Personne resultat = save.execute(personne);
        reponse.execute(resultat);
    }
    public void modifierUnePersonne(Personne personne, Save save,AddReponse reponse){
        Personne resultat = save.execute(personne);
        reponse.execute(resultat);
    }
    public void supprimerUnePersonne(Personne personne, Delete delete, DeleteReponse reponse){
        delete.execute(personne);
        reponse.execute(personne);
    }
    public void supprimerUnePersonne(String idPersonne, Delete delete, DeleteReponse reponse){
        delete.execute(idPersonne);
        reponse.execute(idPersonne);
    }

}
