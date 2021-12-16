package org.stephane.output.mapper.factory;

import org.stephane.output.mapper.TypeServiceMapperEntity;
import org.stephane.output.mapper.factory.ServiceMapperEntity;

public abstract class ServiceMapperFactoryEntity<OUT,DOM> {
    public abstract ServiceMapperEntity<OUT,DOM> create(TypeServiceMapperEntity type);
}
