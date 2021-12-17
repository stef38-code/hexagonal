package org.stephane.in.mapper.factory;

import org.mapstruct.factory.Mappers;

public class ServiceMapperFactoryDtoImpl<I, D> extends ServiceMapperFactoryDto<I, D> {
    @Override
    public ServiceMapperDto<I, D> create(TypeServiceMapperDto type) {
        ServiceMapperDto mapper = Mappers.getMapper(type.getMapperClass());
        return mapper;
    }
}
