package org.stephane.output.mapper.factory;

public interface ServiceMapperFactoryEntity<O, D> {
    public abstract ServiceMapperEntity<O, D> create(TypeServiceMapperEntity type);
}
