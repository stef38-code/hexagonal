package org.stephane.domain.port.out;

public abstract class Supprimer<D> {
    public abstract boolean execute(D domain);

    public abstract boolean execute(String id);
}
