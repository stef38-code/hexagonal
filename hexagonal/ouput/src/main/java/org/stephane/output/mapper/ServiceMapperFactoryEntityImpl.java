package org.stephane.output.mapper;

import org.mapstruct.factory.Mappers;

public class ServiceMapperFactoryEntityImpl<OUT, DOM> extends ServiceMapperFactoryEntity<Object, Object> {
    @Override
    public ServiceMapperEntity<Object, Object> create(TypeServiceMapperEntity type) {
        if (type == TypeServiceMapperEntity.PERSONNE) {
            ServiceMapperEntity mapper = Mappers.getMapper(PersonneEntityMapper.class);
            return mapper;
        }
        throw new IllegalArgumentException("Ce mapper n'est pas definit");
    }
}
