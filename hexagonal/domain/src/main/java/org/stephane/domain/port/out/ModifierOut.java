package org.stephane.domain.port.out;

public interface ModifierOut<D> {
    D execute(D domain);
}
