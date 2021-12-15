package org.stephane.output.mapper;

public abstract class ServiceMapperEntity<OUT,DOM> {
    public abstract OUT toOutput(DOM in);
    public abstract DOM toDomain(OUT out);
}
