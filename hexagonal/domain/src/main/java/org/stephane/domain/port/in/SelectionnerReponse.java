package org.stephane.domain.port.in;

import java.util.Collection;
import java.util.List;

public abstract class SelectionnerReponse<D> {
    public abstract void donnee(D resultat); //resultat donné par la UseCase

    public abstract D recuperee();// récupé

    public abstract void donnees(List<D> resultat); //resultat donné par la UseCase

    public abstract List<D> recuperees();// récupé
}
