package org.stephane.domain.port.out;

public interface SupprimerOut<D> {
    boolean execute(D domain);
boolean execute(String id);
}
