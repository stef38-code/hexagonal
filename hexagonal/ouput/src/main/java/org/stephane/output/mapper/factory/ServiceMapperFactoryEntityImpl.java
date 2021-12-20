package org.stephane.output.mapper.factory;

import org.mapstruct.factory.Mappers;

public class ServiceMapperFactoryEntityImpl<O, D> implements ServiceMapperFactoryEntity<O, D> {
    @Override
    public ServiceMapperEntity<O, D> create(TypeServiceMapperEntity type) {
        ServiceMapperEntity mapper = Mappers.getMapper(type.getMapperClass());
        return mapper;
    }
}
