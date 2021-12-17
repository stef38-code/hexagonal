package org.stephane.output.mapper.factory;

public abstract class ServiceMapperFactoryEntity<OUT,DOM> {
    public abstract ServiceMapperEntity<OUT,DOM> create(TypeServiceMapperEntity type);
}
