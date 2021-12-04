package org.stephane.domain.business.personne;

import org.stephane.domain.entities.Personne;
import org.stephane.domain.port.in.personne.AjouterReponse;
import org.stephane.domain.port.out.personne.Enregistrer;

public class UseCaseModifier {

    public void modifierUnePersonne(Personne personne, Enregistrer enregistrer, AjouterReponse reponse){
        Personne resultat = enregistrer.execute(personne);
        reponse.donner(resultat);
    }
}
