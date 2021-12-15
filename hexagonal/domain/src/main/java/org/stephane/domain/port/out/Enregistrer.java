package org.stephane.domain.port.out;

import org.stephane.domain.entities.Personne;

public abstract class Enregistrer<DOM> {
    public abstract DOM execute(DOM domain);
}
