package org.stephane.domain.port.out;

public abstract class Modifier<D> {
    public abstract D execute(D domain);
}
