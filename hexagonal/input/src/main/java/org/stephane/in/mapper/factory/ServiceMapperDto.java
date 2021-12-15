package org.stephane.in.mapper.factory;

public abstract class ServiceMapperDto<IN,DOM> {
    public abstract IN toInput(DOM in);
    public abstract DOM toDomain(IN out);
}
