package org.stephane.domain.port.out;

import java.util.List;

public interface SelectionnerOut<D> {
    D executer(String id);
    List<D> executer();
}
