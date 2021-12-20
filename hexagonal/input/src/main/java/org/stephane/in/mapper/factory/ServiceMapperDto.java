package org.stephane.in.mapper.factory;

import java.util.List;

public abstract class ServiceMapperDto<I, D> {
    public abstract I toInput(D in);
    public abstract D toDomain(I out);
    public abstract List<I> toInput(List<D> in);
    public abstract List<D> toDomain(List<I> out);
}
