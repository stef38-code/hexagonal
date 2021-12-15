package org.stephane.domain.port.in;

import java.util.Collection;

public abstract class SelectionnerReponse<DOM> {
    public abstract void donnee(DOM resultat); //resultat donné par la UseCase

    public abstract DOM recuperee();// récupé

    public abstract void donnees(Collection<DOM> resultat); //resultat donné par la UseCase

    public abstract Collection<DOM> recuperees();// récupé
}
