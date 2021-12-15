package org.stephane.domain.port.in;

public abstract class AjouterReponse<DOM> {
    public abstract void donner(DOM resultat); //resultat donné par la UseCase

    public abstract DOM recuperer();// récupération par @service par exemple du résultat
}
