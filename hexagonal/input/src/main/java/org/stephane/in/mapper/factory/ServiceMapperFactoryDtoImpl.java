package org.stephane.in.mapper.factory;

import org.mapstruct.factory.Mappers;
import org.stephane.in.mapper.PersonneDtoMapper;

public class ServiceMapperFactoryDtoImpl<I, D> extends ServiceMapperFactoryDto<I, D> {
    @Override
    public ServiceMapperDto<I, D> create(TypeServiceMapperDto type) {
        if (type == TypeServiceMapperDto.PERSONNE) {
            ServiceMapperDto mapper = Mappers.getMapper(PersonneDtoMapper.class);
            return mapper;
        }
        throw new IllegalArgumentException("Ce mapper n'est pas definit");
    }
}
