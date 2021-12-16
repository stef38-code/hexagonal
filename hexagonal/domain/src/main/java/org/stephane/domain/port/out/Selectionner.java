package org.stephane.domain.port.out;

import java.util.List;

public abstract class Selectionner<D> {
    public abstract D executer(String id);
    public abstract List<D> executer();
}
