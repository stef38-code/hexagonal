package org.stephane.domain.port.in;

public abstract class AjouterReponse<D> {
    public abstract void donner(D resultat); //resultat donné par la UseCase
    public abstract D recuperer();// récupération par @service par exemple du résultat
}
