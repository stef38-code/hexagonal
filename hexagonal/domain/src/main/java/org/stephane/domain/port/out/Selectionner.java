package org.stephane.domain.port.out;

import java.util.List;

public abstract class Selectionner<DOM> {
    public abstract DOM executer(String id);
    public abstract List<DOM> executer();
}
