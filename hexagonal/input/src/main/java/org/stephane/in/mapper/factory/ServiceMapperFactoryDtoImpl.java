package org.stephane.in.mapper.factory;

import org.mapstruct.factory.Mappers;
import org.stephane.in.mapper.AdresseDtoMapper;
import org.stephane.in.mapper.PersonneDtoMapper;

public class ServiceMapperFactoryDtoImpl<I, D> extends ServiceMapperFactoryDto<I, D> {
    @Override
    public ServiceMapperDto<I, D> create(TypeServiceMapperDto type) {
        ServiceMapperDto mapper ;
        if (type == TypeServiceMapperDto.PERSONNE) {
            mapper = Mappers.getMapper(PersonneDtoMapper.class);
            return mapper;
        }
        if (type == TypeServiceMapperDto.ADRESSE) {
            mapper = Mappers.getMapper(AdresseDtoMapper.class);
            return mapper;
        }
        throw new IllegalArgumentException("Ce mapper n'est pas definit");
    }
}
