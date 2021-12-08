package org.stephane.domain.port.in.personne;

import org.stephane.domain.entities.Personne;

public interface AjouterUnePersonneReponse {
    void donner(Personne resultat); //resultat donné par la UseCase
    Personne recuperer();// récupération par @service par exemple du résultat
}
