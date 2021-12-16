package org.stephane.output.mapper.factory;

import java.util.Collection;
import java.util.List;

public abstract class ServiceMapperEntity<OUT,DOM> {
    public abstract OUT toOutput(DOM in);
    public abstract List<OUT> toOutput(List<DOM> in);
    public abstract DOM toDomain(OUT out);
    public abstract List<DOM> toDomain(List<OUT> out);
}
