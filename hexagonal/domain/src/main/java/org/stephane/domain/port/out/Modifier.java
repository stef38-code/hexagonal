package org.stephane.domain.port.out;

import org.stephane.domain.entities.Personne;

public abstract class Modifier<DOM> {
    public abstract DOM execute(DOM domain);
}
