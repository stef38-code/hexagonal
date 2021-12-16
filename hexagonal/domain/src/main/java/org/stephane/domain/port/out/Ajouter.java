package org.stephane.domain.port.out;

public interface Ajouter<D> {
    D execute(D domain);
}
