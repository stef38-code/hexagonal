package org.stephane.output.mapper;

import org.mapstruct.factory.Mappers;

public class ServiceMapperFactoryEntityImpl<O, D> extends ServiceMapperFactoryEntity<O, D> {
    @Override
    public ServiceMapperEntity<O, D> create(TypeServiceMapperEntity type) {
        if (type == TypeServiceMapperEntity.PERSONNE) {
            ServiceMapperEntity mapper = Mappers.getMapper(PersonneEntityMapper.class);
            return mapper;
        }
        throw new IllegalArgumentException("Ce mapper n'est pas definit");
    }
}
