package org.stephane.in.mapper.factory;

public abstract class ServiceMapperFactoryDto<IN,DOM> {
    public abstract ServiceMapperDto<IN,DOM> create(TypeServiceMapperDto type);
}
