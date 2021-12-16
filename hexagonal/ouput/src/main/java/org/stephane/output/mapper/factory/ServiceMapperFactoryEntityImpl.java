package org.stephane.output.mapper.factory;

import org.mapstruct.factory.Mappers;
import org.stephane.output.mapper.AdresseEntityMapper;
import org.stephane.output.mapper.PersonneEntityMapper;
import org.stephane.output.mapper.TypeServiceMapperEntity;

public class ServiceMapperFactoryEntityImpl<O, D> extends ServiceMapperFactoryEntity<O, D> {
    @Override
    public ServiceMapperEntity<O, D> create(TypeServiceMapperEntity type) {
        ServiceMapperEntity mapper;
        if (type == TypeServiceMapperEntity.PERSONNE) {
            mapper = Mappers.getMapper(PersonneEntityMapper.class);
            return mapper;
        }
        if (type == TypeServiceMapperEntity.ADRESSE) {
            mapper = Mappers.getMapper(AdresseEntityMapper.class);
            return mapper;
        }
        throw new IllegalArgumentException("Ce mapper n'est pas definit");
    }
}
