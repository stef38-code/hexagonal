package org.stephane.in.mapper.factory;

public abstract class ServiceMapperFactoryDto<I, D> {
    public abstract ServiceMapperDto<I, D> create(TypeServiceMapperDto type);
}
