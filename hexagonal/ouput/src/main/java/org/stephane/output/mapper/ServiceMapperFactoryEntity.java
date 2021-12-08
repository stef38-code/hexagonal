package org.stephane.output.mapper;

public abstract class ServiceMapperFactoryEntity<OUT,DOM> {
    public abstract ServiceMapperEntity<OUT,DOM> create(TypeServiceMapperEntity type);
}
