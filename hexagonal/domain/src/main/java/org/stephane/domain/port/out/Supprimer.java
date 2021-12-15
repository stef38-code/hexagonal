package org.stephane.domain.port.out;

public abstract class Supprimer<DOM> {
    public abstract boolean execute(DOM domain);

    public abstract boolean execute(String id);
}
