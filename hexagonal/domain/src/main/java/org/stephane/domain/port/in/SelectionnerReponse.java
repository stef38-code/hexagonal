package org.stephane.domain.port.in;

import java.util.Collection;

public abstract class SelectionnerReponse<D> {
    public abstract void donnee(D resultat); //resultat donné par la UseCase

    public abstract D recuperee();// récupé

    public abstract void donnees(Collection<D> resultat); //resultat donné par la UseCase

    public abstract Collection<D> recuperees();// récupé
}
