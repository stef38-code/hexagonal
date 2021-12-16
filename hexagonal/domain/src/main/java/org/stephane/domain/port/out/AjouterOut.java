package org.stephane.domain.port.out;

public interface AjouterOut<D> {
    D execute(D domain);
}
